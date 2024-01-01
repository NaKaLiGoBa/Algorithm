class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) return 0;

        Arrays.sort(g);
        Arrays.sort(s);
    
        int greedyIdx = 0;
        int cookieIdx = 0;

        while (greedyIdx < g.length && cookieIdx < s.length) {
            if (g[greedyIdx] <= s[cookieIdx]) {
                greedyIdx++;
            }
            cookieIdx++;
        }
    
        return greedyIdx;
    }
}