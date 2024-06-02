class Solution {
    public int minDistance(String word1, String word2) {
        int size1 = word1.length();
        int size2 = word2.length();
        int[][] dp = new int[size1 + 1][size2 + 1];
        for (int i = 0; i <= size1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(word1, word2, 0, 0, size1, size2, dp);
    }

    private int solve(String word1, String word2, int i, int j, int m, int n, int[][] dp) {
        if (i == m) {
            return n - j;
        }
        if (j == n) {
            return m - i;
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            return solve(word1, word2, i + 1, j + 1, m, n, dp);
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int insert = 1 + solve(word1, word2, i, j + 1, m, n, dp);
        int delete = 1 + solve(word1, word2, i + 1, j, m, n, dp);
        int relate = 1 + solve(word1, word2, i + 1, j + 1, m, n, dp);
        return dp[i][j] = Math.min(insert, Math.min(delete, relate));
    }
}