
import java.io.*;
import java.util.*;

class Main {

    static int N, M;
    static int[][][] SQUARE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] ints = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        N = ints[0];
        M = ints[1];
        SQUARE = new int[N][N][2];

        while (M-- > 0) {
            String[] input = br.readLine().split(" ");
            int y = Integer.parseInt(input[0]) - 1;
            int x = Integer.parseInt(input[1]) - 1;
            String d = input[2];
            drawLine(y, x, d);
        }

        // for (int i = 0; i < N; i++) {
        //     for (int j = 0; j < N; j++) {
        //         System.out.print(Arrays.toString(SQUARE[i][j]));
        //     }
        //     System.out.println();
        // }

        long answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer += countCross(i, j);
            }
        }

        System.out.println(answer);
    }

    private static void drawLine(int y, int x, String d) {
        switch (d) {
            case "U":
                while (y >= 0) {
                    SQUARE[y][x][0] += 1;
                    y -= 1;
                }
                break;
            case "D":
                while (y < N) {
                    SQUARE[y][x][0] += 1;
                    y += 1;
                }
                break;
            case "L":
                while (x >= 0) {
                    SQUARE[y][x][1] += 1;
                    x -= 1;
                }
                break;
            case "R":
                while (x < N) {
                    SQUARE[y][x][1] += 1;
                    x += 1;
                }
                break;
            default:
        }
    }

    private static long countCross(int y, int x) {
        int[] dot = SQUARE[y][x];
        long vertical = dot[0];
        long horizontal = dot[1];
        return vertical * horizontal;
    }
}


