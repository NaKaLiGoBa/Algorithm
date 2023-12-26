class Solution {

    private static final int MOD = (int) Math.pow(10, 9) + 7;
    private int[][] dp;
    private int N, K;

    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        N = n;
        K = k;

        return getWay(n, target);
    }

    private int getWay(int restDice, int target) {
        if (restDice < 0) {
            return 0;
        }

        if (target < 1) {
            return 0;
        }

        if (restDice == 1) {
            if (target > K) return 0;
            return 1;
        }

        if (dp[restDice][target] != -1) {
            return dp[restDice][target];
        }

        int result = 0;
        for (int i = 1; i <= K; i++) {
            result += getWay(restDice - 1, target - i);
            result %= MOD;
        }

        dp[restDice][target] = result;
        return result;
    }
}

