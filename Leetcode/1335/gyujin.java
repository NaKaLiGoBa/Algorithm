class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int JDlength = jobDifficulty.length;

        if (JDlength < d) {
            return -1;
        }

        int[][] dp = new int[d + 1][JDlength + 1];
        // for (int i = 0; i < dp.length; i++) {
        //     Arrays.fill(dp[i], 1001);
        // }
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;

        for (int i = 1; i <= d; i++) {
            for (int j = 0; j <= JDlength; j++) {
                int max = 0;
                for (int k = j - 1; k >= i - 1; k--) {
                    max = Math.max(max, jobDifficulty[k]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + max);
                }
            }
        }

        return dp[d][JDlength];
    }
}