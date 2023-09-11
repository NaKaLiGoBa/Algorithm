import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/12865
// 평범한 배낭
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] wv = new int[n + 1][2];
        int[][] dp = new int[n + 1][k + 1];
        wv[0] = new int[] {0, 0};
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            wv[i + 1] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        // 물건
        for (int i = 1; i < n + 1; i++) {
            // 무게
            for (int j = 1; j < k + 1; j++) {
                dp[i][j] = dp[i-1][j];
                if (wv[i][0] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j - wv[i][0]] + wv[i][1], dp[i - 1][j]);
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
