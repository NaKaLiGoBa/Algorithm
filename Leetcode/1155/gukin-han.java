class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        long[][] dp = new long[n + 1][target+1];
        dp[0][0] = 1;

        for (int row = 1; row < n + 1; row++) {
            for (int col = 1; col < target + 1; col++) {
                long sum = 0;
                for (int i = 1; i <= k; i++) {
                    if (col - i >= 0) {
                        sum += dp[row-1][col - i];
                    }
                    dp[row][col] = sum % 1000000007;
                }
            }
        }

        return (int) dp[n][target];
    }
}

