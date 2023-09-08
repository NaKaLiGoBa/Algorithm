import java.io.*;
import java.util.*;

class Main {
	
	static int N, K, Q;
	static char[][] M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		N = input[0];
		K = input[1];
		Q = input[2];
		M = new char[N][N];
		for (int i = 0; i < N; i++) {
			M[i] = br.readLine().toCharArray();
		}
		while (Q-- > 0) {
			String[] chars = br.readLine().split(" ");
			int r = Integer.parseInt(chars[0]) - 1;
			int c = Integer.parseInt(chars[1]) - 1;
			char ch = chars[2].charAt(0);
			M[r][c] = ch;
			bfs(r, c);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(M[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void bfs(int r, int c) {
		final int[] dR = {0, 0, 1, -1};
		final int[] dC = {1, -1, 0, 0};
		
		int count = 1;
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		List<int[]> clearCandidates = new ArrayList<>();
		queue.offer(new int[]{r, c});
		visited[r][c] = true;
		clearCandidates.add(new int[]{r, c});
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curR = cur[0];
			int curC = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nR = curR + dR[i];
				int nC = curC + dC[i];
				
				if (nR < 0 || nC < 0 || nR >= N || nC >= N) continue;
				if (visited[nR][nC]) continue;
				if (M[nR][nC] != M[r][c]) continue;
				
				queue.offer(new int[]{nR, nC});
				visited[nR][nC] = true;
				clearCandidates.add(new int[]{nR, nC});
				count += 1;
			}
		}
		
		if (count >= K) {
			clear(clearCandidates);
		}
	}
	
	private static void clear(List<int[]> clearCandidates) {
		for (int[] candidate : clearCandidates) {
			int r = candidate[0];
			int c = candidate[1];
			M[r][c] = '.';
		}
	}
}

