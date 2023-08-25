import java.io.*;
import java.util.*;
class Main {
	private static int[][] board;
	private static String[][] position;
	private static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		position = new String[N][N];
		boolean[][] visitedG = new boolean[N][N];
		boolean[][] visitedP = new boolean[N][N];
		
		st = new StringTokenizer(br.readLine());
		int goormR = Integer.parseInt(st.nextToken());
		int goormC = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int playerR = Integer.parseInt(st.nextToken());
		int playerC = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
		  st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				position[i][j] = st.nextToken();
			}
		}
		
		int G = move(goormR - 1, goormC - 1, visitedG);
		int P = move(playerR - 1, playerC - 1, visitedP);
		
		String answer = (G > P) ? "goorm " + G : "player " + P;
		
		System.out.println(answer);
	}
	
	private static int move(int row, int col, boolean[][] visited) {
		int cnt = 0;
		
		while (true) {
			
			if (visited[row][col]) {
				break;
			}
			
			
			visited[row][col] = true;
			cnt++;
			
			char pos = position[row][col].charAt(position[row][col].length() - 1);
			int count = Integer.parseInt(position[row][col].substring(0, position[row][col].length() - 1));
			
			switch (pos) {
				
				case 'U' :
					for (int i = 0; i < count; i++) {
						row = (row - 1 + N) % N;
						if (visited[row][col]) {
							return cnt;
						}
						cnt++;
						if (i == count - 1) {
							cnt--; 
							continue; 
						}
						visited[row][col] = true;
					}
					break;
				
				case 'D' :
					for (int i = 0; i < count; i++) {
						row = (row + 1 + N) % N;
						if (visited[row][col]) {
							return cnt;
						}
						cnt++;
						if (i == count - 1) {
							cnt--; 
							continue;
						}
						visited[row][col] = true;
					}
					break;
				
				case 'R' :
					for (int i = 0; i < count; i++) {
						col = (col + 1 + N) % N;
						if (visited[row][col]) {
							return cnt;
						}
						cnt++;
						if (i == count - 1) {
							cnt--; 
							continue;
						}
						visited[row][col] = true;
					}
					break;
				
				case 'L' :
					for (int i = 0; i < count; i++) {
					 col = (col - 1 + N) % N;
						if (visited[row][col]) {
							return cnt;
						}
						cnt++;
						if (i == count - 1) {
							cnt--; 
							continue;
						}
						visited[row][col] = true;
					}
					break;
				
			}
		}

		return cnt;
	}
}