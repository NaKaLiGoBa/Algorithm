import java.io.*;
import java.util.*;

class Main {
	private static int[] x = {-1, -1, 0, 1, 1, 1, 0 ,-1};
	private static int[] y = {0, 1, 1, 1, 0, -1, -1, -1};
	private static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		map = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] == 0) {
					visited[i][j] = true;
					if (K == searchFlag(i,j)) {
						answer++;
					}
				}
			}
		}
		
		System.out.println(answer);
	}
	private static int searchFlag(int row, int col) {
		int count = 0;
		
		for (int i = 0; i < 8; i++) {
			int dx = row + x[i];
			int dy = col + y[i];
			if (0 <= dx && 0 <= dy && dx < map.length && dy < map.length) {
				if (map[dx][dy] == 1) {
					count++;
				}
			}
		}
		
		return count;
	}
}