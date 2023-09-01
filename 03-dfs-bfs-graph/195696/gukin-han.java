import java.io.*;
import java.util.*;

class Main {
	
	private static int numOfvisited = 0;
	private static int lastNode = 0;
	private static boolean visited[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// get and parse the fisrt line of input
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// init 2D adjacent array as a node and edge container
		List<List<Integer>> adjArr = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			adjArr.add(new ArrayList<Integer>());
		}
		visited = new boolean[N+1];
		
		// get and parse the rest of following lines
		// to populate the adjArr
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int leftNode = Integer.parseInt(st.nextToken()); 
			int rightNode = Integer.parseInt(st.nextToken());
			
			adjArr.get(leftNode).add(rightNode);
			adjArr.get(rightNode).add(leftNode);
		}
		
		bfs(K, adjArr);
		
		System.out.println(numOfvisited + " " + lastNode);
	}
	
	private static void bfs(int start, List<List<Integer>> adjArr) {
		
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (visited[cur]) continue;
			// gather the info
			visited[cur] = true;
			lastNode = cur;
			numOfvisited++;
			
			int smallNodeButNotVisited = 2001; // b.c. the max value of N is 2000
			for (int i = 0; i < adjArr.get(cur).size(); i++) {
				int node = adjArr.get(cur).get(i);
				
				if (visited[node]) continue;
				// find min value algorithm
				if (smallNodeButNotVisited > node) smallNodeButNotVisited = node; 
			}
			if (smallNodeButNotVisited == 2001) break; //  if its value still
			q.add(smallNodeButNotVisited); //  else go through the next node
		}
	}
	
	
}
