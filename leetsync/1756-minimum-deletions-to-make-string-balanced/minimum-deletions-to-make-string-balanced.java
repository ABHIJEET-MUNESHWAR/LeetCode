class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int leftBCount = 0;
        int rightACount = 0;
        int result = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == 'a') {
                rightACount++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                rightACount--;
            }
            result = Math.min(result, leftBCount + rightACount);
            if (s.charAt(i) == 'b') {
                leftBCount++;
            }
        }
        return result;
    }
}