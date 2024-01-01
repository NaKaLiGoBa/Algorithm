class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        int gI = 0;
        for (int i = 0; i < s.length; i++) {
            if (gI == g.length) {
                break;
            }
            if (s[i] >= g[gI]) {
                count += 1;
                gI += 1;
            }
        }

        return count;
    }
}

