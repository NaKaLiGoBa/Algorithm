import java.io.*;
import java.util.*;

class Main {
	private static int[] x = {-1, 1, 0, 0};
	private static int[] y = {0, 0, -1, 1};
	private static Character[][] arr;
	private static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());		// 배열의 크기
		int K = Integer.parseInt(st.nextToken());		// 연결 요소를 지울 기준
		int Q = Integer.parseInt(st.nextToken());  	// 구름이가 문자를 적을 횟수
		
		arr = new Character[N][N];
		
		for (int i = 0; i < N; i++) {		// . 또는 알파벳 대문자
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		for (int i = 0; i < Q; i++) {   // 두 정수 (yi, xi)칸에 di 문자를 적었음.
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			char ch = st.nextToken().charAt(0);
			
			arr[r][c] = ch;	
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
	}
	
	private static void bfs(int row, int col) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {row,col});
		visited[row][col] = true;
		
		while (!queue.isEmpty()) {
			int[] new_pos = queue.poll();
			for (int i = 0; i < 4; i++) {
				int dx = new_pos[0] + x[i];
				int dy = new_pos[1] + y[i];
				if (0 <= dx && 0 <= dy && dx < arr.length && dy < arr.length) {
					if (!visited[dx][dy] && arr[row][col] == arr[dx][dy]) {
						visited[dx][dy] = true;
						queue.add(new int[] {dx, dy});		
						
					}
				}
			}
		}
		
	}
}