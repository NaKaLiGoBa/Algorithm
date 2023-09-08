import java.io.*;
import java.util.*;

class Main {
	private static int N, criteria, Q;
	private static char[][] board;
	private static int[] dRow = new int[]{-1, 1, 0, 0};
	private static int[] dCol = new int[]{0, 0, -1, 1};
	private static boolean globalVisited[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(line.nextToken());
		criteria = Integer.parseInt(line.nextToken());
		Q = Integer.parseInt(line.nextToken());
		
		board = new char[N][N];
		for (int i = 0; i < board.length; i++) {
			board[i] = br.readLine().toCharArray();			
		}
		
		
		for (int i = 0; i < Q; i++) {
			line = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(line.nextToken()) - 1;
			int col = Integer.parseInt(line.nextToken()) - 1;
			char c = line.nextToken().charAt(0);
			
			// 1. draw given text
			drawAt(row, col, c);
			
			globalVisited = new boolean[N][N];
			for (int j = 0; j < board.length; j++) {
				for (int k = 0; k < board[j].length; k++) {
					// 2. count the component size and 
					// if it meets the criteria then remove them
					List<int[]> cache = new ArrayList<>();
					char curChar = board[j][k];
					if (curChar == '.') continue;
					
					if (globalVisited[j][k]) continue;
					globalVisited[j][k] = true;
					
					int componentSize = calcComponentSize(cache, j, k, curChar);
					if (componentSize >= criteria) {
						// System.out.println("init!" + criteria + " " + componentSize);
						removeComponent(cache);
					}
				}
			}
		}
		
		printResult();
		
	}
	
	private static void drawAt(int row, int col, char c) {
		board[row][col] = c;
	}
	
	private static int calcComponentSize(List<int[]> cache, int row, int col, int c) {
		int componentSize = 1;
		// boolean[][] visited = new boolean[N][N];
		// visited[row][col] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{row, col});
		cache.add(new int[]{row, col});
			
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curRow = cur[0];
			int curCol = cur[1];
			globalVisited[curRow][curCol] = true;
			
			for (int i = 0; i < 4; i++) {
				int nextRow = curRow + dRow[i];
				int nextCol = curCol + dCol[i];
				
				if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) continue;
				// if (visited[nextRow][nextCol]) continue;
				if (globalVisited[nextRow][nextCol]) continue;
				// visited[nextRow][nextCol] = true;
				if (board[nextRow][nextCol] != c) continue;
				
				componentSize++;
				q.add(new int[]{nextRow, nextCol});
				cache.add(new int[]{nextRow, nextCol});
				globalVisited[nextRow][nextCol] = true;
			}
			
		}
		
		return componentSize;
	}
	
	private static void removeComponent(List<int[]> cache) {
		for (int[] element: cache) {
			int targetR = element[0];
			int targetC = element[1];
			
			board[targetR][targetC] = '.';
		}
	}
	
	private static void printResult() {
		StringBuilder sb = new StringBuilder();
		
		for (char[] boardRow: board) {
			for (char element: boardRow) {
				sb.append(element);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
