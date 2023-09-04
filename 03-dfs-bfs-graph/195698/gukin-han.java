import java.io.*;
import java.util.*;
class Main {
	private static int N, M, answer;
	private static List<List<Integer>> adjArr = new ArrayList<>();
	private static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(line.nextToken());
		M = Integer.parseInt(line.nextToken());
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			adjArr.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < M; i++) {
			line = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(line.nextToken()) - 1;
			int e = Integer.parseInt(line.nextToken()) - 1;
			adjArr.get(s).add(e);
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			answer++;
			bfs(i);
		}
		
		System.out.println(answer);
	}
	
	private static void bfs(int start) {
		Queue<Integer> outerQ = new LinkedList<>();
		outerQ.add(start);
		
		while (!outerQ.isEmpty()) {
			int current = outerQ.poll();
			for (int element: adjArr.get(current)) {
				if (isCyclic(element, current) && !visited[element]) {
					visited[element] = true;
					outerQ.add(element);
				} 
			}
		}
		
		
	}
	
	private static boolean isCyclic(int element, int current) {
		return adjArr.get(element).contains(current);
	}
}

