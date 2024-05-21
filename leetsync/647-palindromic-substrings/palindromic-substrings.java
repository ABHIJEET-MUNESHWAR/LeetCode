class Solution {
    public int countSubstrings(String s) {
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
        if (s.charAt(left) == s.charAt(right)) {
            return isPalindrome(s, left + 1, right - 1);
        } else {
            return false;
        }
    }
}