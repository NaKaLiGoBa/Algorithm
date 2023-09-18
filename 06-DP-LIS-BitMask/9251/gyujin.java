import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int len1 = str1.length() + 1;
        int len2 = str2.length() + 1;
        int[][] LCS = new int[len1][len2];
        int max = 0;

        for (int i = 1; i < len1; i++) {
            char temp1 = str1.charAt(i - 1);
            for (int j = 1; j < len2; j++) {
                char temp2 = str2.charAt(j - 1);
                if (temp1 == temp2) {
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                }
                else {
                    LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
                }
                max = Math.max(max, LCS[i][j]);
            }
        }
        System.out.println(max);
    }
}
