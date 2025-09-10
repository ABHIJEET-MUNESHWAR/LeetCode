class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();
        char maxChar = ' ';
        for (int i = 2; i < n; i++) {
            if (num.charAt(i) == num.charAt(i - 1) && num.charAt(i) == num.charAt(i - 2)) {
                maxChar = (char) Math.max(maxChar, num.charAt(i));
            }
        }
        return maxChar == ' ' ? "" : new String(new char[] { maxChar, maxChar, maxChar });
    }
}