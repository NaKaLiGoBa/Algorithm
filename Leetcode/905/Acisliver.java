class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] answer = new int[nums.length];

        int left = 0;
        int right = nums.length - 1;

        for (int num : nums) {
            if (num % 2 == 0) {
                answer[left] = num;
                left += 1;
            } else {
                answer[right] = num;
                right -= 1;
            }
        }

        return answer;
    }
}

