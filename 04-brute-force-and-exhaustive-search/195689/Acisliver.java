import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		int[][] board = new int[N][N];
		int answer = 0;
		for (int i = 0; i < N; i++) {
			board[i] = Arrays.stream(br.readLine().split(" "))
									.mapToInt(Integer::parseInt)
									.toArray();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1) continue;
				int goorms = 0;
				for (int dx = -1; dx <= 1; dx++) {
					for (int dy = -1; dy <= 1; dy++) {
						int nI = i + dy;
						int nJ = j + dx;
						if (nI < 0 || nJ < 0 || nI >= N || nJ >= N) continue;
						if (board[nI][nJ] == 1) {
							goorms += 1;
						}
					}
				}
				if (goorms == K) {
					answer += 1;
				}
			}
		}
		System.out.println(answer);
	}
}
