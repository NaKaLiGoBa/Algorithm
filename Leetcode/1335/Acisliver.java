// 300C9

import java.util.Arrays;

class Solution {

    private static final int INF = 999999;

    // 남은 날짜, 마지막 작업 인덱스 = 작업 강도
    int[][] dp = new int[10][300];
    int maxDiff[] = new int[300];

    public int minDifficulty(int[] jobDifficulty, int d) {
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], INF);
        }

        maxDiff[jobDifficulty.length - 1] = jobDifficulty[jobDifficulty.length - 1];
        for (int i = jobDifficulty.length - 2; i >= 0; i--) {
            maxDiff[i] = Math.max(maxDiff[i + 1], jobDifficulty[i]);
        }
        
        int a = getAnswer(0, d - 1, jobDifficulty);

        return a > 10000 ? -1 : a;
    }

    int getAnswer(int jobIdx, int day, int[] diff) {
        // 마지막 날
        // 남은 작업 모두 처리
        if (day == 0) {
            return dp[day][jobIdx] = maxDiff[jobIdx];
        }

        if (dp[day][jobIdx] != INF) {
            return dp[day][jobIdx];
        }

        // [i, j] 구간으로 하루 작업 부여
        for (int i = jobIdx; i < diff.length - day; i++) {
            int diffOfDay = 0;
            for (int j = jobIdx; j < diff.length - day; j++) {
                // 그 날 해야 할 작업 중 최대값 구하기
                diffOfDay = Math.max(diffOfDay, diff[j]);
                dp[day][jobIdx] = Math.min(
                    diffOfDay + getAnswer(j + 1, day - 1, diff),
                    dp[day][jobIdx]
                );
            }
        }

        return dp[day][jobIdx];
    }
}

