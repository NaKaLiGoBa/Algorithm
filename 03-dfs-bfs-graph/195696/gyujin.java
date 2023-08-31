import java.io.*;
import java.util.*;

class Main {
	private static boolean[] visited;
	private static ArrayList<Integer>[] list;
	private static int cnt = 1;
	private static int lastNode;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N + 1];
		list = new ArrayList[N + 1];
		lastNode = K;
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(list[i]);
		}
		
		dfs(K);
		System.out.println(cnt + " " + lastNode);
	}
	
	private static void dfs(int node) {
		visited[node] = true;
		
		for (int new_node : list[node]) {
			if (!visited[new_node]) {
				cnt++;
				lastNode = new_node;
				dfs(new_node);
				break;
			}
		}
	}
	
}