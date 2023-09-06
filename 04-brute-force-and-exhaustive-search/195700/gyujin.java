import java.io.*;
import java.util.*;

class Main {
	private static int[][] visitedRow;
	private static int[][] visitedCol;
	private static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		visitedRow = new int[N][N];
		visitedCol = new int[N][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			char d = st.nextToken().charAt(0);
			
			dot(y, x, d);
		}
		
		long crossDot = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				crossDot += (long) visitedRow[i][j] * visitedCol[i][j];  // 여기에 캐스팅을 안해줬음.
			}
		}
		
		System.out.println(crossDot);
	}
	private static void dot(int row, int col, char direction) {
		
		switch (direction) {
			case 'U' :
				for (int i = row; i >= 0; i--) {
					visitedRow[i][col]++;
				}
				break;
			
			case 'D' :
				for (int i = row; i < N; i++) {
					visitedRow[i][col]++;
				}
				break;
				
			case 'L' :
				for (int i = col; i >= 0; i--) {
					visitedCol[row][i]++;
				}
				break;
				
			case 'R' :
				for (int i = col; i < N; i++) {
					visitedCol[row][i]++;
				}
				break;
		}
	}
	
}