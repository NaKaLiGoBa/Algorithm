import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
//            int m = (int)(Double.parseDouble(st.nextToken()) * 100 + 0.5);
            int m = (int)Math.round(Double.parseDouble(st.nextToken()) * 100);
            if (n == 0 && m == 0) break;
            int[] dp = new int[m + 1];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
//                int p = (int)Math.round(Double.parseDouble(st.nextToken()) * 100);
                int p = (int)(Double.parseDouble(st.nextToken()) * 100 + 0.5);

                for (int j = p; j <= m; j++) {
                    dp[j] = Math.max(dp[j], dp[j - p] + c);
                }
            }

            sb.append(dp[m]).append('\n');
        }
        System.out.print(sb);
    }
}