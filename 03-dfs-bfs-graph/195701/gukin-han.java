import java.io.*;
import java.util.*;

class Main {
	private static int N, M, S, E;
	private static boolean[] visited;
	private static List<List<Integer>> cities = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line = new StringTokenizer(br.readLine());
		N = Integer.parseInt(line.nextToken());
		M = Integer.parseInt(line.nextToken());
		S = Integer.parseInt(line.nextToken()) - 1;
		E = Integer.parseInt(line.nextToken()) - 1;
		
		for (int i = 0; i < N; i++) {
			cities.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < M; i++) {
			line = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(line.nextToken()) - 1;
			int to = Integer.parseInt(line.nextToken()) - 1;
			
			cities.get(from).add(to);
			cities.get(to).add(from);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int day = 0; day < N; day++) {
			sb.append(bfs(day)).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static int bfs(int day) {
		if (day == S) return -1;
		if (day == E) return -1;
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{S, 1});
		visited = new boolean[N];
		visited[S] = true;
		visited[day] = true;
		
		while (!q.isEmpty()) {
			int[] curNode = q.poll();
			int curIdx = curNode[0];
			int level = curNode[1];
			
			for (int i = 0; i< cities.get(curIdx).size(); i++) {
				int nextIdx = cities.get(curIdx).get(i);
				if(visited[nextIdx]) continue;
				visited[nextIdx] = true;
				if (nextIdx == E) return level + 1;
				else q.add(new int[]{nextIdx, level + 1});
			}
			
		}
		
		return -1;
	}
	
}
