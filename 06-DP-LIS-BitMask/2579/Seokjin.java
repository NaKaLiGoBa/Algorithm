import java.util.Scanner;

public class Seokjin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stairsCnt = sc.nextInt();
        int[] arr = new int[301];
        int[] dp = new int[301];

        for(int i=0; i<stairsCnt; i++)
            arr[i] = sc.nextInt();

        dp[0] = arr[0];
        dp[1] = Math.max(arr[0]+arr[1], arr[1]);
        dp[2] = Math.max(arr[0]+arr[2], arr[1]+arr[2]);

        for(int i=3; i<stairsCnt; i++)
            dp[i] = Math.max(dp[i-2]+arr[i], dp[i-3]+arr[i-1]+arr[i]);

        // 세 칸을 연속으로 오르면 안 됨.
        System.out.println(dp[stairsCnt-1]);
    }
}