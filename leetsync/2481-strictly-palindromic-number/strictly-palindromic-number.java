class Solution {
    public boolean isStrictlyPalindromic(int n) {
        for (int base = 2; base < n - 1; base++) {
            int num = n;
            String baseStr = "";
            while (num > 0) {
                baseStr = baseStr + num % base;
                num /= base;
            }
            if (!isPalindrome(baseStr)) {
                return false;
            }
        }
        return true;
    }

    private boolean isPalindrome(String baseStr) {
        int size = baseStr.length();
        int i = 0, j = size - 1;
        while (i < j) {
            if (baseStr.charAt(i) != baseStr.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}