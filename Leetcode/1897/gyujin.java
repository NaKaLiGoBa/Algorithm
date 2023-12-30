class Solution {
    public boolean makeEqual(String[] words) {
        int wordsLen = words.length;
        int[] usedAlpha = new int[26];

          for (String word : words) {
              for (char c : word.toCharArray()) {
                  usedAlpha[c - 'a']++;
              }
          }

          for (int a : usedAlpha) {
              if (a % wordsLen != 0) {
                  return false;
              }
          }
         
        return true;
    }
}