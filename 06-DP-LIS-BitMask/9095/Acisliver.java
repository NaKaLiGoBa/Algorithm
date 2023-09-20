import java.util.Scanner;

// https://www.acmicpc.net/problem/9095
// 1, 2, 3 더하기
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] input = new int[t];
        int[] dp = new int[14];
        for (int i = 0; i < t; i++) {
            input[i] = sc.nextInt();
        }

        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;

        for (int i = 3; i < 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for (int i = 0; i < t; i++) {
            System.out.println(dp[input[i] - 1]);
        }
    }
}

