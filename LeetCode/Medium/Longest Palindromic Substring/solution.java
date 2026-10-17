class Solution {
    int low, maxLength;

    public String longestPalindrome(String s) {
        int size = s.length();
        int maxLength = 0;
        int startingIndex = 0;
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

    private boolean isPalindrome(String s, int i, int j) {
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