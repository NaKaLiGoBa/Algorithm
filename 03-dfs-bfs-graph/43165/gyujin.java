class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
    
    public static void dfs(int[] numbers, int target, int depth, int sum) {
        if(depth == numbers.length) {                                   // 재귀를 탄 횟수가 numbers의 크기만큼 됐다면, 
            if(sum == target) {                                         // target과 numbers를 모두 더한 값과 같다면 답++;
                answer++;
            }
            return;                                                     // 만약 depth == numbers.length가 됐다면 재귀 하나씩 반환.
        }
        
        dfs(numbers, target, depth + 1, sum + numbers[depth]);          // 1 + 1 + 1 + 1 + 1 로 시작하여
        dfs(numbers, target, depth + 1, sum - numbers[depth]);          // 1 + 1 + 1 + 1 - 1 부터 재귀 파티.
    }
}