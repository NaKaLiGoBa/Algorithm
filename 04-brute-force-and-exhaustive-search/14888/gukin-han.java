import java.io.*;
import java.util.*;

public class Main {
    private static int[] givenNums;
    private static int[] operators;
    private static int numOfGivenNums;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numOfGivenNums = Integer.parseInt(br.readLine());
        givenNums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        operators = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        dfs(1 , givenNums[0]);
        System.out.println(max + "\n" + min);
    }


    private static void dfs(int depth, int result) {
        if (depth == numOfGivenNums) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        int currentNum = givenNums[depth];
        for (int i = 0; i < 4; i++) {
            if (operators[i] == 0) continue;
            operators[i]--;
            switch (i) {
                case 0: dfs(depth+1, result + currentNum); break;
                case 1: dfs(depth+1, result - currentNum); break;
                case 2: dfs(depth+1, result * currentNum); break;
                case 3: dfs(depth+1, result / currentNum); break;
            }
            operators[i]++;
        }
    }

}
