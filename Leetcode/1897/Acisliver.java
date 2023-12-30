class Solution {
    public boolean makeEqual(String[] words) {
        int[] alphabetCount = new int[26];
        int wordCount = words.length;

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                alphabetCount[word.charAt(i) - 'a'] += 1;
            }
        }

        for (int count : alphabetCount) {
            if (count % wordCount != 0) {
                return false;
            }
        }

        return true;
    }
}

