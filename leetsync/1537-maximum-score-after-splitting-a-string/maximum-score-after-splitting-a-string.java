class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int result = Integer.MIN_VALUE;
        int zeros = 0;
        int ones = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '1') {
                ones++;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                zeros++;
            } else {
                ones--;
            }
            result = Math.max(result, zeros + ones);
        }
        return result;
    }
}