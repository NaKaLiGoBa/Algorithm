import java.io.*;
import java.util.*;

public class Main {
    static int[] x = {0, 1, 0, -1};
    static int[] y = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] map;
    static int N, M = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                int temp = Integer.parseInt(str.substring(j, j + 1));
                map[i][j] = temp;
            }
        }

        bfs(0, 0);

        System.out.println(map[N - 1][M - 1]);                      // 결국, 마지막 위치에 남아있는 누적값을 출력.
    }

    private static void bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {row, col});                               // 큐에 값이 두 개 들어있는 배열을 넣음.
        visited[row][col] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int i = 0; i < 4; i++) {
                int dx = now[0] + x[i];
                int dy = now[1] + y[i];

                if(0 <= dx && 0 <= dy && dx < N && dy < M) {
                    if(!visited[dx][dy] && map[dx][dy] == 1) {
                        visited[dx][dy] = true;
                        map[dx][dy] = map[now[0]][now[1]] + 1;          // map의 1인 곳을 따라가는데, 1씩 누적해줌.
                        queue.add(new int[] {dx, dy});                  // 다시 큐에 현재 위치가 들어있는 배열을 넣음.
                    }
                }
            }
        }

    }
}
