class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int size1 = s1.length();
        int size2 = s2.length();
        int size3 = s3.length();
        Boolean[][][] dp = new Boolean[size1 + 1][size2 + 1][size3 + 1];
        return solve(s1, s2, s3, size1, size2, size3, 0, 0, 0, dp);
    }

    private boolean solve(String s1, String s2, String s3, int m, int n, int o, int i, int j, int k, Boolean[][][] dp) {
        if (i >= m && j >= n && k >= o) {
            return true;
        }
        if (k >= o) {
            return false;
        }
        if (dp[i][j][k] != null) {
            return dp[i][j][k];
        }
        boolean result = false;
        if (i < m && s1.charAt(i) == s3.charAt(k)) {
            result = solve(s1, s2, s3, m, n, o, i + 1, j, k + 1, dp);
        }
        if (result) {
            return dp[i][j][k] = true;
        }
        if (j < n && s2.charAt(j) == s3.charAt(k)) {
            result = solve(s1, s2, s3, m, n, o, i, j + 1, k + 1, dp);
        }
        return dp[i][j][k] = result;
    }
}