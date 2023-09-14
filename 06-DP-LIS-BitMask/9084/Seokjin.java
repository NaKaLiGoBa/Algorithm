import java.util.*;

public class Seokjin {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i=0; i<t; i++) {
            int n = sc.nextInt();
            int[] coinGenre = new int[n];

            for(int l=0; l<n; l++)
                coinGenre[l] = sc.nextInt();

            int m = sc.nextInt();
            int[] dp = new int[m+1];

            dp[0] = 1;
            for(int k=0; k<coinGenre.length; k++) {
                for(int j=coinGenre[k]; j<=m; j++)
                    dp[j] += dp[j-coinGenre[k]];
            }

            System.out.println(dp[m]);
        }
    }
}