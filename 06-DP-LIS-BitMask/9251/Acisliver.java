import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        int[][] dp = new int[str1.length + 1][str2.length + 1];

        for (int i = 0; i < str1.length; i++) {
            char c1 = str1[i];
            for (int j = 0; j < str2.length; j++) {
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                char c2 = str2[j];
                if (c1 == c2) {
                    dp[i + 1][j + 1] = Math.max(dp[i][j] + 1, dp[i + 1][j + 1]);
                }
            }
        }

        System.out.println(dp[str1.length][str2.length]);
    }
}


