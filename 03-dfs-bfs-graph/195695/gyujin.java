import java.io.*;
import java.util.*;

class Main {	
	private static int[] x = {-1, 1, 0, 0};
	private static int[] y = {0, 0, -1, 1};
	private static boolean[][] visited;
	private static int[][] village;
	private static int[] count = new int[1001];
	// private static Map<Integer, Integer> generator = new HashMap();
	private static int K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		village = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				village[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]){
					power(i, j);
				}
			}
		}

		int max = -1;
		int idx = 0;
		for(int i = 1000; i > 0; i--) {
			if (max < count[i]) {
				max = count[i];
				idx = i;
			}
		}
		
		System.out.println(idx);
		// generator.forEach((key, value) -> {
		// 	System.out.println(Math.max());
		// });
		
	}
	private static void power(int row, int col) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {row, col});
		visited[row][col] = true;
		int num = village[row][col];
		int cnt = 1;
		
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			for (int i = 0; i < 4; i++) {
				int dx = x[i] + node[0];
				int dy = y[i] + node[1];
				if (0 <= dx && 0 <= dy && dx < visited.length && dy < visited.length) {
					if (!visited[dx][dy] && num == village[dx][dy]) {
						visited[dx][dy] = true;
						cnt++;
						queue.add(new int[] {dx, dy});
					}
				}
			}
		}
			if (K <= cnt) {
				count[num]++;
				// if (!generator.containsKey(num)) generator.put(num, 1);
				// else generator.put(num, generator.get(num) + 1);	
			}
	}
	
}