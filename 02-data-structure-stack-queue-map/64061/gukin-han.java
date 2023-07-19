import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> bucket = new Stack<>();
        int answer = 0;
        
        for(int move:moves) {
            int pickedUp = pickUp(board, move);
            if (pickedUp != 0) { // picked up somthing
                if (bucket.isEmpty() || bucket.peek() != pickedUp) bucket.push(pickedUp);
                else if(bucket.peek() == pickedUp) {
                    bucket.pop();
                    answer += 2;
                }
            }
        }
        return answer;
    }
    
    private int pickUp(int[][] board, int move) {
        int col = move - 1;
        for (int row = 0; row < board.length; row++) {
            int pickedUp = board[row][col];
            if (pickedUp != 0) {
                board[row][col] = 0; // remove
                return pickedUp;
            };
        }
        return 0;
    }
}
