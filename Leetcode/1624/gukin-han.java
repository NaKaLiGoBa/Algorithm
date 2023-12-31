class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) map.put(c, new ArrayList<>());
            map.get(c).add(i);
        }

        int result = -2;
        for (List list: map.values()) {
            int last = list.size() - 1;
            int diff = 0;
            if (last == 0) {
                diff = -1;
            } else {
                diff = (int) list.get(last) - (int) list.get(0) - 1;
            }
            result = Math.max(result, diff);
        }

        return result;
    }
}
