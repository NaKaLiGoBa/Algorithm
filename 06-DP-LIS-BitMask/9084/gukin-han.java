import java.io.*;
import java.util.*;
public class Main {

    private static int T, N;
    private static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            int[] coins = new int[N];
            StringTokenizer line = new StringTokenizer(br.readLine());

            for (int j = 0; j < coins.length; j++) {
                coins[j] = Integer.parseInt(line.nextToken());
            }

            int M = Integer.parseInt(br.readLine());
            int[][] memo = new int[N + 1][M + 1];

            for (int j = 0; j <= N; j++) {
                memo[j][0] = 1;
            }

            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= M; k++) {
                    memo[j][k] = memo[j-1][k];
                    if (k-coins[j-1] >= 0) {
                        memo[j][k] += memo[j][k - coins[j-1]];
                    }

                }
            }


            answer.append(memo[N][M] + "\n");
        }
        System.out.println(answer.toString());
    }
}
