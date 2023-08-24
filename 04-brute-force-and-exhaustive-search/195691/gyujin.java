import java.io.*;
import java.util.*;

class Main {
	private static int[] x = {0, -1, 1, 0, 0};
	private static int[] y = {0, 0, 0, -1, 1};
	private static String[][] ground;
	private static int[][] scoreMap;
	private static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ground = new String[N][N];
		scoreMap = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				ground[i][j] = st.nextToken();
				scoreMap[i][j] = 0;
			}
		}
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int tempX = Integer.parseInt(st.nextToken());
			int tempY = Integer.parseInt(st.nextToken());
			
			bomb(tempX - 1, tempY - 1);	
		}
		
		System.out.println(max);
	}
	private static void bomb (int row, int col) {
		for (int i = 0; i < 5; i++) {
			int dx = row + x[i];
			int dy = col + y[i];
			if (0 <= dx && 0 <= dy && dx < ground.length && dy < ground.length && !ground[dx][dy].equals("#")) {
				if (ground[dx][dy].equals("@")) scoreMap[dx][dy] += 2;
				else scoreMap[dx][dy] += 1;
				max = Math.max(max, scoreMap[dx][dy]);
			}
		}
	}
	
}