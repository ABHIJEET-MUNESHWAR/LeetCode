class Solution {

    int m, n, N;
    Boolean dp[][];

    public boolean check(String s1, String s2, String s3, int i, int j) {
        if (i >= m && j >= n && i + j >= N) {
            return true;
        }

        if (i + j >= N) {
            return false;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        boolean result = false;

        if (i < m && s1.charAt(i) == s3.charAt(i + j)) {
            result = check(s1, s2, s3, i + 1, j);
        }

        if (result == true) {
            return dp[i][j] = result;
        }

        if (j < n && s2.charAt(j) == s3.charAt(i + j)) {
            result = check(s1, s2, s3, i, j + 1);
        }
        return dp[i][j] = result;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        m = s1.length();
        n = s2.length();
        N = s3.length();

        if (m + n != N) {
            return false;
        }

        dp = new Boolean[m + 1][n + 1];
        return check(s1, s2, s3, 0, 0);

    }
}