import java.util.Scanner;

public class Seokjin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 물품의 수
        int k = sc.nextInt(); // 버틸 수 있는 최대 무게
        int[] dp = new int[k + 1]; // 인덱스 1부터 k까지

        for (int i = 0; i < n; i++) {
            int w = sc.nextInt(); // 각 물건의 무게
            int v = sc.nextInt(); // 해당 물건의 가치

            for (int l = k; l >= w; l--)
                dp[l] = (dp[l] < dp[l - w] + v) ? dp[l - w] + v : dp[l];
        }

        System.out.println(dp[k]);
    }
}