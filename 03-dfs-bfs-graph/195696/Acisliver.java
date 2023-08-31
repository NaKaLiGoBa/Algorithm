import java.io.*;
import java.util.*;

class Main {
	
	static List<Integer> NODES = new ArrayList<>();
	static boolean[][] EDGES;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int K = Integer.parseInt(input[2]) - 1;
		EDGES = new boolean[N][N];
		boolean[] visited = new boolean[N];
		visited[K] = true;
		NODES.add(K);
		
		while (M-- > 0) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]) - 1;
			int b = Integer.parseInt(input[1]) - 1;
			EDGES[a][b] = true;
			EDGES[b][a] = true;
		}
		
		int cur = K;
		while (true) {
			boolean isAdd = false;
			
			for (int nx = 0; nx < N; nx++) {
				if (visited[nx]) continue;
				if (!EDGES[cur][nx]) continue;
				cur = nx;
				visited[nx] = true;
				NODES.add(nx);
				isAdd = true;
				break;
			}
			
			if (!isAdd) break;
		}
		
		System.out.printf("%d %d", NODES.size(), NODES.get(NODES.size() - 1) + 1);
	}

}

