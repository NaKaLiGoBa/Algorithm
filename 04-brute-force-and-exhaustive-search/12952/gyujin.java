class Solution {
    static int[] chess;                     // 각 원소의 index를 '열', 각 원소 값을 '행'
    static int answer = 0;
    public int solution(int n) {
        chess = new int[n];
        
        nQueen(n, 0);
        
        return answer;
    }
    
    public static void nQueen(int n, int depth) {
        
        if (depth == n) {                       // 주어진 n만큼 재귀가 돌아갔을경우, 성공했다는 뜻이므로 answer++
            answer++;
            return;
        }
        
        for (int i = 0; i < n; i++) {           // 열마다 각 행에 퀸을 놓아보면서 놓을 수 있는 체크.
            chess[depth] = i;
            if (Possibility(depth)) {
                nQueen(n, depth + 1);
            }
        }
    }
    
    public static boolean Possibility(int col) {    
    
        for (int i = 0; i < col; i++) {
            
            if(chess[col] == chess[i]) {        // 열끼리의 원소값이 같으면 같은 행에 위치해 있다는 것이므로 false 반환.
                return false;
            }
            
            else if(Math.abs(col - i) == Math.abs(chess[col] - chess[i])) {         // 열의 차와 행의 차가 같을 경우가 대각선상에 놓여있는 경우.
                return false;
            }
        }
        return true;        // 위에 두가지 조건에 해당하지 않으면 true 반환.
    }
}