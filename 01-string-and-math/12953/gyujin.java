class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        if(arr.length == 1) return answer;
        
        else {
            for(int i = 1; i < arr.length; i++) {
                answer = lcm(answer, arr[i]);
            }
            return answer;
        }
    }
    
    static int gcd(int a, int b) {
        if(b == 0)  return a;
        else {
            return gcd(b, a % b);
        }
    }
    
    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
    
}