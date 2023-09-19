import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] memo = new int[n + 1];

            memo[1] = 1;
            if (n == 1) {
                sb.append(memo[1]);
                sb.append("\n");
                continue;
            }

            memo[2] = 2;
            if (n == 2) {
                sb.append(memo[2]);
                sb.append("\n");
                continue;
            }

            memo[3] = 4;
            if (n == 3) {
                sb.append(memo[3]);
                sb.append("\n");
                continue;
            }

            for (int j = 4; j < memo.length; j++) {
                
                int caseOne = memo[j - 1];
                int caseTwo = memo[j - 2];
                int caseThree = memo[j - 3];
                memo[j] = caseOne + caseTwo + caseThree;
            }
            sb.append(memo[n]);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
