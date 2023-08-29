import java.io.*;
import java.util.*;

class Main {
	
	static int N;
	static int[][] M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = new int[N][N];
		for (int i = 0; i < N; i++) {
			M[i] = Arrays.stream(br.readLine().split(" "))
									.mapToInt(Integer::parseInt)
									.toArray();
		}
		
		boolean[][] visited = new boolean[N][N];
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (M[i][j] == 1 && visited[i][j] == false) {
					bfs(i, j, visited);
					count += 1;
				}
			}
		}
		
		System.out.println(count);
	}
	
	private static void bfs(int r, int c, boolean[][] visited) {
		final int[] dR = {0, 0, -1, 1};
		final int[] dC = {1, -1, 0, 0};
		
		Queue<int[]> queue = new LinkedList<>();
		visited[r][c] = true;
		queue.offer(new int[]{r, c});
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cR = cur[0];
			int cC = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nR = cR + dR[i];
				int nC = cC + dC[i];
				
				if (nR < 0 || nC < 0 || nR >= N || nC >= N) continue;
				if (visited[nR][nC]) continue;
				if (M[nR][nC] == 0) continue;
				
				visited[nR][nC] = true;
				queue.offer(new int[]{nR, nC});
			}
		}
	}
}

