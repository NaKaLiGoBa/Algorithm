import java.io.*;
import java.util.*;

class Main {
	private static int numOfPS = 0;
	private static int[] dRow = new int[]{-1, 1, 0, 0};
	private static int[] dCol = new int[]{0, 0, -1, 1};
	private static int N;
	private static int[][] M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = new int[N][N];
		
		for (int row = 0; row < N; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int col = 0; col < N; col++) {
				M[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if(M[row][col] != 1) continue;
				numOfPS++;
				bfs(row, col);
			}
		}
		
		System.out.println(numOfPS);
	}
	
	private static void bfs(int row, int col) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{row, col});
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curRow = cur[0];
			int curCol = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int newRow = curRow + dRow[i];
				int newCol = curCol + dCol[i];
				
				if (newRow < 0 || newCol < 0 || newRow >= N || newCol >= N || M[newRow][newCol] != 1) continue;
				M[newRow][newCol] = 0;
				
				q.offer(new int[]{newRow, newCol});
			}
		}
	}
}
