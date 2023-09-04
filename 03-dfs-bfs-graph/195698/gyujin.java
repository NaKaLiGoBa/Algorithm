import java.io.*;
import java.util.*;

class Main {
	private static ArrayList<Integer>[] list;
	private static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			list[s].add(e);
			// list[e].add(s);
		}
		
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				unionIsle(i);
				cnt++;
			}
		}
		
	System.out.println(cnt);
	}
	private static void unionIsle(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;
		
		while(!queue.isEmpty()) {
			int new_node = queue.poll();
			for (int i : list[new_node]) {
				if (!visited[i] && list[i].contains(new_node)) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}
	
}