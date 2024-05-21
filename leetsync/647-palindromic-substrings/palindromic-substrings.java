class Solution {

    int[][] dp = new int[1001][1001];

    public int countSubstrings(String s) {
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                dp[i][j] = -1;
            }
        }
        int count = 0;
        int size = s.length();
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (isPalindrome(s, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isPalindrome(String s, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (dp[left][right] != -1) {
            return dp[left][right] == 1;
        }
        if (s.charAt(left) == s.charAt(right)) {
            boolean val = isPalindrome(s, left + 1, right - 1);
            if (val) {
                dp[left][right] = 1;
            } else {
                dp[left][right] = 0;
            }
            return val;
        }
        dp[left][right] = 0;
        return false;
    }
}