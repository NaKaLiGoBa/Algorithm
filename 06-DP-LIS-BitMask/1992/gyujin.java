import java.io.*;
import java.util.*;

public class Main {
    private static char[][] displayed;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        displayed = new char[N][N];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                displayed[i][j] = temp.charAt(j);
            }
        }

        System.out.println(quadTree(0, 0, N));
    }
    private static String quadTree(int row, int col, int len) {
        if (division(row, col, len)) {
            return String.valueOf(displayed[row][col]);
        }
        else {
            int half = len / 2;
            StringBuilder sb = new StringBuilder();
            sb.append("(")
                    .append(quadTree(row, col, half))
                    .append(quadTree(row, col + half, half))
                    .append(quadTree(row + half, col, half))
                    .append(quadTree(row + half, col + half, half))
                    .append(")");
            return sb.toString();
        }
    }
    private static boolean division(int row, int col, int len) {
        char first = displayed[row][col];
        for (int i = row; i < row + len; i++) {
            for (int j = col; j < col + len; j++) {
                if (displayed[i][j] != first) {
                    return false;
                }
            }
        }
        return true;
    }
}