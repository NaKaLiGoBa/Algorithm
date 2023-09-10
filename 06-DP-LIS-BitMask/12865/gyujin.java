import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());           // 물건의 개수
        int K = Integer.parseInt(st.nextToken());           // 최대 무게

        int[][] wAndH = new int[N][2];
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());       // 물건의 무게
            int V = Integer.parseInt(st.nextToken());       // 행복

            wAndH[i][0] = W;
            wAndH[i][1] = V;
        }
/*
        Arrays.sort(wAndH, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o2[1], o1[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });
*/
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (wAndH[i - 1][0] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], wAndH[i - 1][1] + dp[i - 1][j - wAndH[i - 1][0]]);
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}