import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String vertical = br.readLine();
        String horizontal = br.readLine();
        int[][] lcs = new int[vertical.length() + 1][horizontal.length() + 1];

        for (int i = 1; i < lcs.length; i++) {
            char vChar = vertical.charAt(i - 1);
            for (int j = 1; j < lcs[i].length; j++) {
                char hChar = horizontal.charAt(j - 1);

                if (vChar == hChar) lcs[i][j] = lcs[i - 1][j - 1] + 1;
                else lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
            }
        }

        System.out.println(lcs[vertical.length()][horizontal.length()]);
    }
}
