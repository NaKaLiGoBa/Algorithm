class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] first = new int[26]; 
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        int answer = -1;

        for (int i = 0; i < s.length(); ++i) {
            int idx = s.charAt(i) - 'a';

            if (first[idx] == -1) {
                first[idx] = i;
            } else {
                last[idx] = i;
                answer = Math.max(answer, last[idx] - first[idx] - 1);
            }
        }

        return answer;
    }
}

