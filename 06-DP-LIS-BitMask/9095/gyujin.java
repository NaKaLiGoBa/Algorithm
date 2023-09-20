import java.io.*;
import java.util.*;

public class Main {
    private static int[] dp = new int[11];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int cnt = 0;
            
            if (dp[n] != 0) {
                sb.append(dp[n]).append('\n');
                continue;
            }
            three(n, cnt);
            sb.append(dp[n]).append('\n');
        }
        System.out.println(sb);
    }
    private static void three(int N, int count) {
        if (N < count) return;

        if (N == count) {
            dp[N]++;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            count += i;
            three(N, count);
            count -= i;
        }
    }
}
