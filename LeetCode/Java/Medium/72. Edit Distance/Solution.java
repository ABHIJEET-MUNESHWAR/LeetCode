class Solution {
    public int minDistance(String word1, String word2) {
        int size1 = word1.length();
        int size2 = word2.length();
        return solve(word1, word2, 0, 0, size1, size2);
    }

    private int solve(String word1, String word2, int i, int j, int m, int n) {
        if (i == m) {
            return n - j;
        }
        if (j == n) {
            return m - i;
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            return solve(word1, word2, i + 1, j + 1, m, n);
        }
        int insert = 1 + solve(word1, word2, i, j + 1, m, n);
        int delete = 1 + solve(word1, word2, i + 1, j, m, n);
        int relate = 1 + solve(word1, word2, i + 1, j + 1, m, n);
        return Math.min(insert, Math.min(delete, relate));
    }
}