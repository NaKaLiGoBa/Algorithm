import java.util.*;

public class Seokjin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int[][] dp = new int[str1.length()+1][str2.length()+1]; // 8(0~7)

        for(int i=1; i<str1.length()+1; i++) {
            for(int l=1; l<str2.length()+1; l++) {
                if(str1.charAt(i-1) == str2.charAt(l-1))
                    dp[i][l] = dp[i-1][l-1] + 1;
                else
                    dp[i][l] = Math.max(dp[i-1][l], dp[i][l-1]);
            }
        }

        System.out.println(dp[str1.length()][str2.length()]);
    }
}