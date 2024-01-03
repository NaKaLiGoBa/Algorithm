/*
class Solution {
    public int numberOfBeams(String[] bank) {
        int answer = 0;
        int now = 0;
        boolean accept = false;
        int[] device = new int[bank.length];

        for (int i = 0; i < bank.length; i++) {
            int razer = 0;
            for (int j = 0; j < bank[0].length(); j++) {
                char ch = bank[i].charAt(j);
                if (ch - '0' == 0) {
                    continue;
                }
                razer++;
            }
            device[i] = razer;
        }

        for (int beam : device) {
            if (beam == 0) {
                continue;
            }
            if (!accept) {
                now = beam;      
                accept = !accept;          
            } else {
                answer += now * beam;
                now = beam;
            }
            
        }
        return answer;
    }
}
*/
class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0;
        int answer = 0;

        for (String s : bank) {
            int cnt = 0;
            for (char ch : s.toCharArray()) {
                cnt += ch - '0';
            }
            
            if (0 < cnt) {
                answer += prev * cnt;
                prev = cnt;
            }
        }
        return answer;
    }
}

