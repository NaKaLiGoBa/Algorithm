class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int answer = 0;
        
        // // Approch 1: Stack
        // Stack<Character> colorStack = new Stack<>();
        // Stack<Integer> timeStack = new Stack<>();

        // for (int i = 0; i < n; i++) {
        //     char curColor = colors.charAt(i);
        //     int curTime = neededTime[i];

        //     if (colorStack.isEmpty()) {
        //         colorStack.push(curColor);
        //         timeStack.push(curTime);
        //     } else {
        //         if (colorStack.peek() == curColor) {
        //             if (timeStack.peek() <= curTime) {
        //                 answer += timeStack.pop();
        //                 colorStack.pop();
        //                 timeStack.push(curTime);
        //                 colorStack.push(curColor);
        //             } else {
        //                 answer += curTime;
        //             }
        //         } else {
        //             colorStack.push(curColor);
        //             timeStack.push(curTime);
        //         }
        //     }
        // }
        // return answer;

        // Approach 2: keep tracking last index
        int prevIdx = 0;
        for (int i = 1; i < n; i++) {
            if (colors.charAt(i) == colors.charAt(prevIdx)) {
                if (neededTime[i] <= neededTime[prevIdx]) {
                    answer += neededTime[i];
                } else {
                    answer += neededTime[prevIdx];
                    prevIdx = i;
                }
            } else {
                prevIdx = i;
            }
        }

        return answer;
    }
}
