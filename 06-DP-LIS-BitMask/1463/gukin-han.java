import java.io.*;
import java.util.*;
public class Main {

    private static int N;
    private static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        memo = new int[N+1];

        for (int i = 2; i <= N; i++) {
            int caseOfMinusOne = Integer.MAX_VALUE;
            int caseOfDivByTwo = Integer.MAX_VALUE;
            int caseOfDivByThree = Integer.MAX_VALUE;

            if (i - 1 > 0) caseOfMinusOne = memo[i-1] + 1;
            if (i % 2 == 0) caseOfDivByTwo = memo[i/2] + 1;
            if (i % 3 == 0) caseOfDivByThree = memo[i/3] + 1;

            memo[i] = Math.min(Math.min(caseOfMinusOne, caseOfDivByTwo), caseOfDivByThree);
        }

        System.out.println(memo[N]);
    }
}
