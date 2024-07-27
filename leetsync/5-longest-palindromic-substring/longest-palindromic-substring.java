class Solution {

    int[][] dp = new int[1001][1001];

    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLength = 0;
        int startIndex = 0;
        for (int i = 0; i < 1001; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j)) {
                    if (maxLength < (j - i + 1)) {
                        maxLength = j - i + 1;
                        startIndex = i;
                    }
                }
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }

    public boolean isPalindrome(String s, int i, int j) {
        if (i >= j) {
            return true;
        }
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }
        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = isPalindrome(s, i + 1, j - 1) ? 1 : 0;
        } else {
            dp[i][j] = 0;
        }
        return dp[i][j] == 1;
    }
}