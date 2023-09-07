import java.io.*;
import java.util.*;

class Main {
	private static ArrayList<Integer>[] list;
	private static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list[u].add(v);
			list[v].add(u);
		}
		
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			visited[i] = true;
			sb.append(bfs(S, E)).append('\n');
			visited[i] = false;
		}
		
		System.out.println(sb);
	}
	private static int bfs(int startNode, int endNode) {
		if (visited[startNode]) return -1;
				
		Queue<Integer> queue = new LinkedList<>();
		queue.add(startNode);
		
		int[] nodeCnt = new int[visited.length];
		nodeCnt[startNode] = 1;
		
		while (!queue.isEmpty()) {
			int nextNode = queue.poll();
			for (int i : list[nextNode]) {
				if (!visited[i]) {
					visited[i] = true;
					nodeCnt[i] = nodeCnt[nextNode] + 1;
					queue.add(i);
					if (i == endNode) {
						return nodeCnt[i];
					}
				}
			}
		}
		
		return -1;
	}
}