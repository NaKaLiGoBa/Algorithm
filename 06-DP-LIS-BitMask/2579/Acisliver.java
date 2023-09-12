import java.util.Scanner;

// https://www.acmicpc.net/problem/2579
// 계단 오르기
// 동적 프로그래밍
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stairs = new int[n + 2];
        int[] dp = new int[n + 2];
        for (int i = 0; i < n; i++) {
            stairs[i] = sc.nextInt();
        }

        dp[0] = stairs[0];
        dp[1] = Math.max(dp[0] + stairs[1], stairs[1]);
        dp[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i]);
        }

        System.out.println(dp[n - 1]);
    }
}



