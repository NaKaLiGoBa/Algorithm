class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;
        for (int num : nums) {
            int value = map.getOrDefault(num, 0);
            map.put(num, value + 1);
            max = Math.max(value + 1, max);
        }

        for (int i = 0; i < max; i++) {
            answer.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
            for (int i = 0; i < en.getValue(); i++) {
                answer.get(i).add(en.getKey());
            }
        }

        return answer;
    }
}

