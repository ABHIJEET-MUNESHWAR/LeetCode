class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        boolean isPalindrome = true;
        s = s.toLowerCase();
        int l = 0, r = n - 1;
        while (l < r) {
            if (l < n && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
                continue;
            }
            if (r >= 0 && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
                continue;
            }
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return isPalindrome;
    }
}