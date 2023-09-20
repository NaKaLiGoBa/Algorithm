import java.io.*;
import java.util.*;
public class Main {

    private static final int[] NUMS = new int[]{1, 2, 3};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] memo = new int[n + 1];

            for (int j = 1; j < memo.length; j++) {

                for (int num : NUMS) {
                    if (j - num < 0) continue;
                    else if (j - num == 0) memo[j] += 1;
                    else memo[j] += memo[j - num];
                }
            }
            sb.append(memo[n]);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
