package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

// 동물원
// https://www.acmicpc.net/problem/1309
public class N1309 {

    private static final int DIV = 9901;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][3];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % DIV;
            dp[i][1] = (dp[i - 1][0] +dp[i - 1][2]) % DIV;
            dp[i][2] = (dp[i - 1][0] +dp[i - 1][1]) % DIV;
        }

        System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % DIV);
    }
}

