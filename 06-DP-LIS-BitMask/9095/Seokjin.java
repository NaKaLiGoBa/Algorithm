import java.util.*;

public class Seokjin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] arr = new int[t];
        int[] dp = new int[11];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=0; i<t; i++)
            arr[i] = sc.nextInt();

        for(int i=4; i<11; i++)
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];

        for(int i=0; i<t; i++)
            System.out.println(dp[arr[i]]);
    }
}