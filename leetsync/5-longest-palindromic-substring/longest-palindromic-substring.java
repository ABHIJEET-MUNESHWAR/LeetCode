class Solution {

    int[][] dp = new int[1001][1001];

    public String longestPalindrome(String s) {
        int size = s.length();
        int maxLength = 0;
        int startingIndex = 0;
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (isPalindrome(s, i, j)) {
                    if (maxLength < (j - i + 1)) {
                        maxLength = j - i + 1;
                        startingIndex = i;
                    }
                }
            }
        }
        return s.substring(startingIndex, startingIndex + maxLength);
    }

    private boolean isPalindrome(String s, int l, int r) {
        if (l >= r) {
            return true;
        }
        if (dp[l][r] != -1) {
            return dp[l][r] == 1;
        }
        if (s.charAt(l) == s.charAt(r)) {
            dp[l][r] = isPalindrome(s, l + 1, r - 1) ? 1 : 0;
        } else {
            dp[l][r] = 0;
        }
        return dp[l][r] == 1;
    }
}