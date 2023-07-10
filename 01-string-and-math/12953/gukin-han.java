import java.util.*;

class Solution {
    public int solution(int[] arr) {
        // sort order by ascending
        Arrays.sort(arr);
        int answer = 0;
        int maxElement = arr[arr.length - 1];
        boolean isCM = false;
        while (!isCM) {
            isCM = true;
            answer += maxElement;
            for (int i = 0; i < arr.length - 1; i++) {
                int otherElement = arr[i];
                if (answer % otherElement != 0) {
                    isCM = false;
                }
            }
        }
        
        return answer;
    }
}
