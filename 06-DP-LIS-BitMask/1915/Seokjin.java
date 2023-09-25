import java.util.*;
import java.io.*;

public class Seokjin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = 0;

        int[][] dp = new int[n+1][m+1];

        for(int i=1; i<=n; i++) {
            String str = br.readLine();

            for(int l=1; l<=m; l++) {
                char ch = str.charAt(l-1);

                // 좌, 좌상, 상
                if(ch == '1') {
                    dp[i][l] = Math.min(dp[i][l-1], Math.min(dp[i-1][l-1], dp[i-1][l])) + 1;
                    result = Math.max(dp[i][l], result);
                }
            }
        }

        System.out.println(result*result);
    }
}