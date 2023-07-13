import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp = new int[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            System.out.println(Combination(M, N));
        }
    }

    private static int Combination(int m, int n) {

        if(dp[m][n] != 0) return dp[m][n];              // 배열을 처음 초기화하면 기본값으로 0이 채워지는데, 0이 아니면 값이 채워져있다는 것이므로 배열값 반환.

        if (m == n || n == 0) return dp[m][n] = 1;      // mCn 공식을 이용하여 m과 n이 같거나 n 값이 0이면 결과는 1이 되기 때문에 1 반환.

        else return dp[m][n] = Combination(m - 1, n - 1) + Combination(m - 1, n);   // 콤비네이션 재귀를 통해 처음 한번만 지나치면 다음부터는 저장된 값을 꺼내쓸수있음.
    }
}
