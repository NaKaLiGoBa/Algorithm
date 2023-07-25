import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11724
// 연결 요소의 개수
public class Main {
    private static int n, m;
    private static int count;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        boolean[][] matrix = new boolean[n][n];
        count = 0;
        visited = new boolean[n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;
            matrix[n1][n2] = true;
            matrix[n2][n1] = true;
        }
        for (int i = 0; i < n; i++) {
             if (!visited[i]) {
                 dfs(i, matrix);
                 count++;
             }
        }
        System.out.println(count);
    }

    private static void dfs(int i, boolean[][] matrix) {
        for (int j = 0; j < n; j++) {
            if (!visited[j] && matrix[i][j]) {
                visited[j] = true;
                dfs(j, matrix);
            }
        }
    }
}

