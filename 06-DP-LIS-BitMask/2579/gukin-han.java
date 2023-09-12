import java.io.*;
import java.util.*;
public class Main {

    private static int N;
    private static int[] steps, memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        steps = new int[N+1];
        memo = new int[N+1];
        Arrays.fill(memo, -1);


        for (int i = 1; i <= N; i++) {
            steps[i] = Integer.parseInt(br.readLine());
        }


        memo[1] = steps[1];
        if (N >= 2) {
            memo[2] = steps[1] + steps[2];
        }
        dp(N);

        System.out.println(memo[N]);

    }

    private static int dp(int step) {
        if (step <= 0) return 0;

        else if (memo[step] != -1) return memo[step];

        int twoSteps = dp(step - 2) + steps[step];
        int aStep = dp(step - 3) + steps[step - 1] + steps[step];
        memo[step] = Math.max(aStep, twoSteps);

        return memo[step];
    }
}
