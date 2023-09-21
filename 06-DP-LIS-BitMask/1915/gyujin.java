import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] square = new int[n + 1][m + 1];
        int[][] dp = new int[n + 1][m + 1];
        int max = 0;

        for (int i = 1; i <= n; i++) {
            String num = br.readLine();
            for (int j = 1; j <= m; j++) {
                square[i][j] = Integer.parseInt(num.substring(j - 1,j));
                if (square[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        System.out.println(max * max);
    }
}