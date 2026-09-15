class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];

        for (int i = 0; i < n; ++i)
            isPal[i][i] = true;

        for (int i = 0; i + 1 < n; ++i)
            if (s.charAt(i) == s.charAt(i + 1))
                isPal[i][i + 1] = true;

        for (int len = 3; len <= n; ++len)
            for (int i = 0; i + len - 1 < n; ++i) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && isPal[i + 1][j - 1])
                    isPal[i][j] = true;
            }

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1];
            for (int j = 0; j <= i - k; ++j)
                if (isPal[j][i - 1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
        }
        return dp[n];
    }
}