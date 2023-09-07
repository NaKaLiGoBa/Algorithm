import java.io.*;
import java.util.*;

class Main {
	
	static int N, M, S, E;
	static List<List<Integer>> graph = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		N = input[0];
		M = input[1];
		S = input[2] - 1;
		E = input[3] - 1;
		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}
		while (M-- > 0) {
			input = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
			int u = input[0] - 1;
			int v = input[1] - 1;
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(bfs(i));
		}		
	}
	
	private static int bfs(int day) {
		if (S == day) return -1;
		if (E == day) return -1;
		
		Queue<int[]> queue = new LinkedList<>();
		boolean[] visited = new boolean[N];
		queue.add(new int[]{S, 1});
		visited[S] = true;
		visited[day] = true;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curNode = cur[0];
			int curDay = cur[1];
			List<Integer> nexts = graph.get(curNode);
			
			for (Integer next : nexts) {
				if (visited[next]) continue;
				if (next == E) return curDay + 1;
				queue.add(new int[]{next, curDay + 1});
				visited[next] = true;
			}
		}
		
		return -1;
	}
}

