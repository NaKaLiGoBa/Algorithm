class Solution {
    private static int answer = 0;
    private static int[] board;
    
    
    public int solution(int n) {
        board = new int[n];
        
        dfs(n ,0);
        return answer;
    }
    
    private void dfs(int n, int curCol) {
        if (curCol == n) {
            answer++;
            return;
        }
        
        for (int row = 0; row < n; row++) {
            board[curCol] = row;
            if (promising(curCol)) dfs(n, curCol + 1);
        }
        
    }
    
    private boolean promising(int givenCol) {
        for (int col = 0; col < givenCol; col++) {
            if (board[givenCol] == board[col] 
                || (givenCol - col) == (int) Math.abs(board[givenCol] - board[col])) {
                return false;
            }
        }
        
        return true;
    }
}
