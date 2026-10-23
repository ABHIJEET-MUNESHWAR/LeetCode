class Solution {
    public int minDistance(String word1, String word2, int m, int n, int i, int j) {
        if (i == m) {
            return n - j;
        }
        if (j == n) {
            return m - i;
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            return minDistance(word1, word2, m, n, i + 1, j + 1);
        }
        int insert = 1 + minDistance(word1, word2, m, n, i, j + 1);
        int delete = 1 + minDistance(word1, word2, m, n, i + 1, j);
        int replace = 1 + minDistance(word1, word2, m, n, i + 1, j + 1);
        return Math.min(insert, Math.min(delete, replace));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        return minDistance(word1, word2, m, n, 0, 0);
    }
}