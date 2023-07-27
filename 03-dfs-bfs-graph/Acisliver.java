import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/2178
// 미로 탐색
public class Main {

    private static int n, m;
    private static int[] DX = new int[]{0, 0, -1, 1};
    private static int[] DY = new int[]{-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        int[][] miro = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                miro[i][j] = s.charAt(j) - '0';

            }
        }

        bfs(miro);

        System.out.println(miro[n-1][m-1]);
    }

    // (0, 0)부터 bfs
    private static void bfs(int[][] miro) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            for (int i = 0; i < 4; i++) {
                int nextX = curX + DX[i];
                int nextY = curY + DY[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
                    continue;
                if (visited[nextX][nextY] || miro[nextX][nextY] == 0)
                    continue;

                queue.add(new int[]{nextX, nextY});
                visited[nextX][nextY] = true;
                miro[nextX][nextY] = miro[curX][curY] + 1;
            }
        }

    }
}

