class Solution {
    int n;
    int[][] dp;
    public int minDifficulty(int[] jobDifficulty, int d) {
        this.n = jobDifficulty.length;
        dp = new int[n][d];
        for (int[] subDp: dp) Arrays.fill(subDp, -1);

        if (n < d) return -1;
        else if (n == d) return Arrays.stream(jobDifficulty).sum();
        return dfs(jobDifficulty, 0, d - 1);
    }

    public int dfs(int[] jobDifficulty, int start, int d) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        if (d == 0) {
            for (int i = start; i < n; i++) {
                int diff = jobDifficulty[i];
                max = Math.max(max, diff);
            }
            return max;
        }

        if (dp[start][d] != -1) return dp[start][d];

        for (int i = start; i < n - d; i++) {
            int diff = jobDifficulty[i];
            max = Math.max(max, diff);
            min = Math.min(min, max + dfs(jobDifficulty, i + 1, d - 1));
        }

        dp[start][d] = min;
        return min;
    }
}
