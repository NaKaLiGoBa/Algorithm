class Solution {
    public int minCost(String colors, int[] neededTime) {
        int[] dp = new int[colors.length()];
        Arrays.fill(dp, -1);
        return calcMinCost(colors.length() - 1, colors, neededTime, dp, '|', 0);
    }

    private int calcMinCost(int i, String colors, int[] neededTime, int[] dp, char newColor, int newTime) {
        if (i < 0) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        if (colors.charAt(i) == newColor) {    // i 번째 풍선이 새 풍선과 색이 같을 경우
            dp[i] = calcMinCost(i - 1, colors, neededTime, dp, colors.charAt(i), Math.max(neededTime[i], newTime)) + Math.min(neededTime[i], newTime);
        } else {
            dp[i] = calcMinCost(i - 1, colors, neededTime, dp, colors.charAt(i), neededTime[i]);
        }

        return dp[i];
    }
}

