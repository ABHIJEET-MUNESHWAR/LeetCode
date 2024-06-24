class Solution {

    int[][] dp;

    public int minimumDeleteSum(String s1, String s2) {
        dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return solveRecursionMemoization(s1, s2, 0, 0);
    }

    private int solveRecursionMemoization(String s1, String s2, int i, int j) {
        if (i >= s1.length() && j >= s2.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (i >= s1.length()) {
            return dp[i][j] = s2.charAt(j) + solveRecursionMemoization(s1, s2, i, j + 1);
        }
        if (j >= s2.length()) {
            return dp[i][j] = s1.charAt(i) + solveRecursionMemoization(s1, s2, i + 1, j);
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = solveRecursionMemoization(s1, s2, i + 1, j + 1);
        }
        int deleteIthS1 = s1.charAt(i) + solveRecursionMemoization(s1, s2, i + 1, j);
        int deleteJthS2 = s2.charAt(j) + solveRecursionMemoization(s1, s2, i, j + 1);
        return dp[i][j] = Math.min(deleteIthS1, deleteJthS2);
    }

}