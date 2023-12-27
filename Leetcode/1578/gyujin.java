class Solution {
    public int minCost(String colors, int[] neededTime) {
        int time = 0;
        char preColor = 'A';
        int preIndex = -1;

        for (int i = 0; i < colors.length(); i++) {
            char selectColor = colors.charAt(i);
            if (preColor != selectColor) {
                preColor = selectColor;
                preIndex = i;
                continue;
            }
            if (neededTime[preIndex] < neededTime[i]) {
                time += neededTime[preIndex];
                preColor = selectColor;
                preIndex = i;
                continue;
            }
            time += neededTime[i];
        }

        return time;
    }
}