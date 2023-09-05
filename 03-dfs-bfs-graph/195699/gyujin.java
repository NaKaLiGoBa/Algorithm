import java.io.*;
import java.util.*;

class Main {
	private static ArrayList<Integer>[] list;
	private static boolean[] visited;
	private static double max = -1;
	private static ArrayList<Integer> nodes = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				bfs(i);
			}
		}
		
		for (int node : nodes) {
			sb.append(node).append(" ");
		}
		
		System.out.println(sb);
	}
	
	private static void bfs(int node) {
		Queue<Integer> queue = new LinkedList();
		ArrayList<Integer> tempNodes = new ArrayList<>();
		queue.add(node);
		tempNodes.add(node);
		visited[node] = true;
		
		int connCnt = 0;
		while (!queue.isEmpty()) {
			int new_node = queue.poll();
			for (int i : list[new_node]) {
				connCnt++;
				if (!visited[i]) {
					tempNodes.add(i);
					visited[i] = true;
					queue.add(i);
				}
			}
		}
		double density = (double) (connCnt / 2) / tempNodes.size();
		Collections.sort(tempNodes);
		
		if (max < density) {
			max = density;
			nodes = tempNodes;
		}
		else if (density == max) {
			if (tempNodes.size() < nodes.size() || (tempNodes.size() == nodes.size() && tempNodes.get(0) < nodes.get(0))) {
				nodes = tempNodes;
			}
		}
	}
}