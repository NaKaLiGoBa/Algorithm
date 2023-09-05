import java.io.*;
import java.util.*;

class Main {
	
	static int N, M, C;
	static boolean[] visited;
	static boolean[][] GRAPH;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] ints = Arrays.stream(br.readLine().split(" "))
										.mapToInt(Integer::parseInt)
										.toArray();
		N = ints[0];
		M = ints[1];
		C = 0;
		visited = new boolean[N];
		GRAPH = new boolean[N][N];
		while (M-- > 0) {
			ints = Arrays.stream(br.readLine().split(" "))
										.mapToInt(Integer::parseInt)
										.toArray();
			int s = ints[0] - 1;
			int e = ints[1] - 1;
			GRAPH[s][e] = true;
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			C += 1;
			visited[i] = true;
			visitUnion(i);
		}
		
		System.out.println(C);
	}
	
	private static void visitUnion(int cur) {
		for (int nx = 0; nx < N; nx++) {
			if (visited[nx]) continue;
			if (GRAPH[cur][nx] && GRAPH[nx][cur]) {
				visited[nx] = true;
				visitUnion(nx);
			}
		}
	}
}

