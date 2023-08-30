import java.io.*;
import java.util.*;

class Main {
	private static int[] x = {0, 1, 0, -1};
	private static int[] y = {1, 0, -1, 0};
	private static boolean[][] visited;
	private static int[][] generator;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		generator = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				generator[i][j] = Integer.parseInt(st.nextToken());	
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (generator[i][j] == 1 && !visited[i][j]) {
					BFS(i, j);
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
	
	private static void BFS(int row, int col) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {row, col});
		visited[row][col] = true;
		
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			for (int i = 0; i < 4; i++) {
				int dx = x[i] + node[0];
				int dy = y[i] + node[1];
				if (0 <= dx && 0 <= dy && dx < generator.length && dy < generator.length) {
					if (!visited[dx][dy] && generator[dx][dy] == 1) {
						visited[dx][dy] = true;
						queue.add(new int[] {dx, dy});
					}	
				}	
			}	
		}
	}
/* 	
	private static void DFS(int row, int col) {
		visited[row][col] = true;
		
		for (int i = 0; i < 4; i++) {
			int dx = row + x[i];
			int dy = col + y[i];
			if (0 <= dx && 0 <= dy && dx < generator.length && dy < generator.length) {
				if (!visited[dx][dy] && generator[dx][dy] == 1) {
					visited[dx][dy] = true;
					install(dx, dy);
				}
			}
		}
	}
*/
}