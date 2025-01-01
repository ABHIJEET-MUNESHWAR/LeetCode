class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int result = Integer.MIN_VALUE;
        int zeros = 0, ones = 0;
        for (int i = 0; i < n - 1; i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                zeros++;
            } else {
                ones++;
            }
            result = Math.max(result, zeros - ones);
        }
        if (s.charAt(n - 1) == '1') {
            ones++;
        }
        return result + ones;
    }
}