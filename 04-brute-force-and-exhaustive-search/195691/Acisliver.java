import java.util.*;
import java.io.*;
class Main {
	
	private static final int[] DX = {0, 0, 0, -1, 1};
	private static final int[] DY = {0, -1, 1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		String[][] board = new String[n][n];
		int[][] score = new int[n][n];
		int answer = 0;
		for (int i = 0; i < n; i++) {
			board[i] = br.readLine().split(" ");
		}
		
		while (k-- > 0) {
			input = br.readLine().split(" ");
			int y = Integer.parseInt(input[0]) - 1;
			int x = Integer.parseInt(input[1]) - 1;
			
			for (int i = 0; i < 5; i++) {
				int nY = y + DY[i];
				int nX = x + DX[i];
				
				if (nY < 0 || nX < 0 || nY >= n || nX >= n) continue;
				String str = board[nY][nX];
				switch (str) {
					case "0":
						score[nY][nX] += 1;
						break;
					case "@":
						score[nY][nX] += 2;
						break;
					default:
						break;
				}
				answer = Math.max(answer, score[nY][nX]);
			}
		}
		
		// System.out.println(Arrays.deepToString(score));
		System.out.println(answer);
	}
}
