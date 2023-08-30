import java.io.*;
import java.util.*;

class Main {
	
	static int N, K;
	static int[][] M;
	static Map<Integer, Integer> countsByBuilding = new HashMap<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);
		M = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			M[i] = Arrays.stream(br.readLine().split(" "))
									.mapToInt(Integer::parseInt)
									.toArray();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j]) continue;
				bfs(i, j, visited);
			}
		}
		
		int answer = 0;
		int max = 0;
		for (var e : countsByBuilding.entrySet()) {
			if (max < e.getValue()) {
				answer = e.getKey();
				max = e.getValue();
				continue;
			}
			if (max == e.getValue() && answer < e.getKey()) {
				answer = e.getKey();
			}
		}
		
		System.out.println(answer);
		// System.out.println(countsByBuilding);
	}
	
	private static void bfs(int r, int c, boolean[][] visited) {
		final int[] dR = {0, 0, -1, 1};
		final int[] dC = {1, -1, 0, 0};
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{r, c});
		visited[r][c] = true;
		int group = M[r][c];
		int count = 1;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cR = cur[0];
			int cC = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nR = cR + dR[i];
				int nC = cC + dC[i];
				
				if (nR < 0 || nC < 0 || nR >= N || nC >= N) continue;
				if (visited[nR][nC]) continue;
				if (M[nR][nC] != group) continue;
				
				queue.offer(new int[]{nR, nC});
				visited[nR][nC] = true;
				count += 1;
			}
		}
		
		if (count < K) return;
		
		countsByBuilding.merge(group, 1, Integer::sum);
	}
}

