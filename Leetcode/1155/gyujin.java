class Solution {
    final static int modulo = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        int[] answer = new int[target + 1];
        answer[0] = 1;

        for (int i = 1; i <= n; i++) {
            int[] temp = new int[target + 1];
            
            for (int j = 1; j <= k; j++) {
                for (int l = target; l >= j; l--) {
                    temp[l] = (temp[l] + answer[l - j]) % modulo;
                }
            }
            answer = temp;
        }

        return answer[target];
    }
}