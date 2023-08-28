package groom;
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] ITEMS;
    static int[] DP;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ITEMS = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        DP = new int[N + 1];
        Arrays.fill(DP, 123456789);
        DP[0] = 0;

        for (int i = 1; i <= N; i++) {
            for (int item : ITEMS) {
                if (i >= item) {
                    DP[i] = Math.min(DP[i - item] + 1, DP[i]);
                }
            }
        }

        if (DP[N] == 123456789) {
            System.out.println(-1);
            return;
        }

        System.out.println(DP[N]);
    }
}


