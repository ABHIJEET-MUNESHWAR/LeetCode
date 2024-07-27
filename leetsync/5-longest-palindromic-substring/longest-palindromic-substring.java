class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLength = 1;
        int startIndex = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i + l <= n; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j) && (dp[i + 1][j - 1] || l == 2)) {
                    dp[i][j] = true;
                    if (maxLength < l) {
                        maxLength = l;
                        startIndex = i;
                    }
                }
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }
}