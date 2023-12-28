/*
class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        String str = "";
        Stack<Character> numberOfChar = new Stack<>();

        numberOfChar.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (numberOfChar.peek() == letter) {
                numberOfChar.push(letter);
                if (i == s.length() - 1) {
                    if (1 < numberOfChar.size()) {
                        str += numberOfChar.peek() + String.valueOf(numberOfChar.size());
                    } else {
                        str += numberOfChar.peek();
                    }
                }
                continue;
            }
            if (1 < numberOfChar.size()) {
                str += numberOfChar.peek() + String.valueOf(numberOfChar.size());
            } else {
                str += numberOfChar.peek();
            }
            numberOfChar.clear();
            numberOfChar.push(letter);

            if (i == s.length() - 1) {
                if (1 < numberOfChar.size()) {
                    str += numberOfChar.peek() + String.valueOf(numberOfChar.size());
                } else {
                    str += numberOfChar.peek();
                }
                break;
            }
        }
        System.out.println(str);
        return str.length();
    }
    public static int lowerLen() {

        return str.length();
    }
}

문제점
1. 문자열 s의 마지막 인덱스를 어떻게 처리할지 방법을 못찾음.
2. 문자열을 이용해 가공하는 것이 비효율적.
3. 문자열을 추가하면서 검사하는데 문자열을 덧붙이는 것 이외에 문자열을 빼는 등에서 문제 발생.
4. 문자열 자체로 이용할 것이 아닌 배열을 이용해서 인덱스와 문자열을 그때그때 만들어서 길이를 측정하는 것이 아닌 int형 변수로 알아내보자.
5. Stack or ArrayList로 접근을 시작하였는데, DP 문제 이해 부족.
*/

class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        int[][] dp = new int[101][101];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = 9999;
            }
        }
        dp[0][0] = 0;
        
        for (int i = 1; i <= n; i++) {          
            for (int j = 0; j <= k; j++) {      
                int cnt = 0, del = 0;           
                for (int l = i; l >= 1; l--) {  
                    if (s.charAt(l - 1) == s.charAt(i - 1)) 
                        cnt++;
                    else 
                        del++;
                    
                    if (j - del >= 0) {    
                        dp[i][j] = Math.min(dp[i][j], dp[l - 1][j - del] + 1 + (cnt >= 100 ? 3 : cnt >= 10 ? 2 : cnt >= 2 ? 1 : 0));
                    }
                }
                if (j > 0)          
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
            }
        }
        return dp[n][k];
    }
}


