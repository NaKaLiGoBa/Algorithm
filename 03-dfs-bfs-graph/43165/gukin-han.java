class Solution {
    private static int[][] cache;
    private static int answer = 0;
    public int solution(int[] numbers, int target) {
        // initializr
        int numOfCase = (int) Math.pow(2, numbers.length);
        cache = new int[numbers.length][numOfCase];
        cache[0][0] += numbers[0];
        cache[0][1] -= numbers[0];
        dfs(numbers, 0, 0, target);
        dfs(numbers, 0, 1, target);
        
        return answer;
    }
    
    private void dfs(int[] numbers, int depth, int col, int target) { 
        int curValue = cache[depth][col];
        if (depth+1 == cache.length) {
            if (curValue == target) answer++;
            return;
        }
        
        int leftChildCol = col*2;
        int rightChildCol = col*2 + 1;
        cache[depth+1][leftChildCol] = curValue + numbers[depth+1];
        cache[depth+1][rightChildCol] = curValue - numbers[depth+1];
        dfs(numbers, depth+1, leftChildCol, target);
        dfs(numbers, depth+1, rightChildCol, target);
    }
}
