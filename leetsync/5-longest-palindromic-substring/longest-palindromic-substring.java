class Solution {

    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLength = 0;
        int startIndex = 0;
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
        if (s.charAt(i) == s.charAt(j)) {
            return isPalindrome(s, i + 1, j - 1);
        } else {
            return false;
        }
    }
}