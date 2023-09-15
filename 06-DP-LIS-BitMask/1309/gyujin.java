import java.io.*;
import java.util.*;

public class Main {
    private static final int mod = 9901;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        dp[0] = 1;
        dp[1] = 3;

        for (int i = 2; i <= N; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1] * 2) % mod;
        }

        System.out.println(dp[N]);
    }
    /*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1][3];

        dp[1][0] = 1; 
        dp[1][1] = 1;
        dp[1][2] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % mod;  // N = 2부터 위에 있는 칸이 비어있을 경우, 3번의 경우의 수가 다 올수있음.
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;                // .. 위에 있는 칸의 왼쪽이 차있을 경우, 비어있는 경우의 수와 오른쪽이 채워져있는 경우의 수가 올 수 있음.
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % mod;                // .. 위에 있는 칸의 오른쪽이 차있을 경우, 비어있는 경우의 수와 왼쪽이 채워져있는 경우의 수가 올 수 있음.
        }

        System.out.println((dp[N][0] + dp[N][1] + dp[N][2] % mod));        // 결국, 국인님의 풀이와 대은님의 풀이가 일맥상통 함.
    }
    */
    
}
