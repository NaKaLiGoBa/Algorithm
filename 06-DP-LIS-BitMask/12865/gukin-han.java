import java.io.*;
import java.util.*;
public class Main {

    private static int numOfItem, maxWeightCapa;
    private static int[] weightOfIthItem, valueOfIthItem;
    private static int[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(br.readLine());

        numOfItem = Integer.parseInt(line.nextToken());
        maxWeightCapa = Integer.parseInt(line.nextToken());
        weightOfIthItem = new int[numOfItem + 1];
        valueOfIthItem = new int[numOfItem + 1];
        memo = new int[numOfItem + 1][maxWeightCapa + 1];

        for (int i = 1; i <= numOfItem; i++) {
            line = new StringTokenizer(br.readLine());
            weightOfIthItem[i] = Integer.parseInt(line.nextToken());
            valueOfIthItem[i] = Integer.parseInt(line.nextToken());
        }

        for (int i = 1; i <= numOfItem; i++) {
            for (int weightCapa = 1; weightCapa <= maxWeightCapa; weightCapa++) {
                solver(i, weightCapa);
            }
        }

        System.out.println(memo[numOfItem][maxWeightCapa]);
    }

    private static void solver(int i, int weightCapa) {
        if (weightOfIthItem[i] > weightCapa) {
            memo[i][weightCapa] = memo[i - 1][weightCapa];
        } else {
            memo[i][weightCapa] = Math.max(memo[i - 1][weightCapa], memo[i - 1][weightCapa - weightOfIthItem[i]] + valueOfIthItem[i]);
        }
    }
}
