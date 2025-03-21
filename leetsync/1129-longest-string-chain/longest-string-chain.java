class Solution {

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        int size = words.length;
        int[] dp = new int[size];
        for (int i = 0; i < size; i++) {
            dp[i] = 1;
        }
        int maxLength = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (isPredecessor(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLength = Math.max(maxLength, dp[i]);
                }
            }
        }
        return maxLength;
    }

    private boolean isPredecessor(String word1, String word2) {
        int size1 = word1.length();
        int size2 = word2.length();
        if ((size1 >= size2) || ((size2 - size1) > 1)) {
            return false;
        }
        int i = 0, j = 0;
        while (i < size1 && j < size2) {
            if (word1.charAt(i) == word2.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == size1;
    }
}