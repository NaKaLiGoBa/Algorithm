import java.io.*;
import java.util.*;
public class Main {

    private static final int MOD = 9901;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] memo = new int[N + 1];
        memo[0] = 1;
        memo[1] = 3;

        for (int i = 2; i <= N ; i++) {
            memo[i] = (memo[i - 1] * 2 + memo[i - 2]) % MOD;
        }

        System.out.println(memo[N]);
    }
}
