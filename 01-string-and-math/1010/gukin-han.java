import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] cache = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // the number of test cases
        int numOfTests = Integer.parseInt(br.readLine());

        // loop through getCombination to print out the answer
        StringBuilder answer = new StringBuilder();
        for(int test = 0; test < numOfTests; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // nCr:
            // pick r points at west(left) side of river
            // out of n points at east(right) side of river
            int r = Integer.parseInt(st.nextToken()); // west side
            int n = Integer.parseInt(st.nextToken()); // east side

            answer.append(getCombination(n, r)).append("\n");
        }
        System.out.println(answer.toString());
    }

    private static int getCombination(int n, int r) {
        // caching
        if (cache[n][r] > 0) return cache[n][r];
        if (n == r || r == 0) return cache[n][r] = 1;
        // based on Pascal's triangle
        else return cache[n][r] = getCombination(n-1, r-1) + getCombination(n-1, r);
    }
}

