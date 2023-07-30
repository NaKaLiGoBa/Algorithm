class Solution {
    private static int[] board;
    private static int count;
    
    public int solution(int n) {
        board = new int[n + 1];
        count = 0;
        Solution s = new Solution();
        s.nQueen(0, n);
        return count;
        
    }
    
    public void nQueen(int i, int n) {

        if (valid(i)) {
            if (i == n) {
                count++;
                return;
            }
            for (int m = 1; m <= n; m++) {
                board[i + 1] = m;
                nQueen(i + 1, n);
            }
        }
    }
    
    public boolean valid(int i) {

        int j = 1;

        while (j < i) {
            // 같은 열확인
            if (board[i] == board[j]) return false;

            // 왼쪽 대각선 확인 \
            if (board[i] == board[j] - i + j) return false;

            // 오른쪽 대각선 확인 /
            if (board[i] == board[j] + i - j) return false;

            j++;
        }

        return true;
    }
}

