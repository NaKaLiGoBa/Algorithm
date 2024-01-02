class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> answerArr = new ArrayList<List<Integer>>();
        List<Integer> tempArr = new ArrayList<Integer>();
        boolean[] checkedIdx = new boolean[nums.length];
        int[] list = new int[201];
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            list[nums[i]]++;
        }

        for (int i = 1; i < 201; i++) {
            max = Math.max(max, list[i]);
        }
        
        while (max-- > 0) {
            for (int i = 0; i < nums.length; i++) {
                if (!tempArr.contains(nums[i])) {
                    if (!checkedIdx[i]) {
                        tempArr.add(nums[i]);
                        checkedIdx[i] = true;
                    }
                }
            }
            answerArr.add(new ArrayList<>(tempArr));
            tempArr.clear();
        }
        
        return answerArr;
    }
}