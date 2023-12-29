import java.util.Arrays;

class Solution {

    static final int INF = 123456789;

    int[][] dp;

    public int getLengthOfOptimalCompression(String s, int k) {
        dp = new int[k + 1][s.length() + 1];
        for (int i = 0; i <= k; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][0] = 0;
        dp[0][1] = 1;
        int a = recur(s.length(), s, k);
        return a;
    }

    private int recur(int cur, String s, int delete) {
        if (cur <= delete) { // 남은 문자를 모두 제거할 수 있는 경우
            return 0;
        }

        if (dp[delete][cur] != INF) {
            return dp[delete][cur];
        }

        // 1. 제거하는 경우
        if (delete > 0) {
            dp[delete][cur] = Math.min(recur(cur - 1, s, delete - 1), dp[delete][cur]);
        }

        // 2. 제거하지 않는 경우 -> 압축 시도
        int size = 1;
        int k = delete;
        for (int i = cur - 1; i >= 0; i--) {
            int len = determineLen(size);
            dp[delete][cur] = Math.min(recur(i, s, k) + len, dp[delete][cur]);

            if (s.charAt(i) != s.charAt(cur - 1)) {
                if (k > 0) {    // 해당 문자를 제거해본다.
                    k -= 1;
                } else {        // 제거할 수 없다면 종료
                    break;
                }
            } else {
                if (i == 0) {
                    len = determineLen(size);
                    dp[delete][cur] = Math.min(recur(i, s, k) + len, dp[delete][cur]);
                } else {
                    size += 1;
                }
            }
        }
        return dp[delete][cur];
    }

    private int determineLen(int size) {
        if (size >= 100) {
            return 4;
        } else if (size >= 10) {
            return 3;
        } else {
            return 2;
        }
    }
}

