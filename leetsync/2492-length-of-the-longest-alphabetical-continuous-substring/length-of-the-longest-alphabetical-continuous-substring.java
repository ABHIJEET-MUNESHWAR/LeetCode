class Solution {
    public int longestContinuousSubstring(String s) {
        int size = s.length();
        int maxLength = 1;
        int currentMax = 1;
        char[] chars = s.toCharArray();
        for (int i = 1; i < size; i++) {
            if (chars[i] - chars[i - 1] == 1) {
                currentMax++;
            } else {
                currentMax = 1;
            }
            maxLength = Math.max(maxLength, currentMax);
        }
        return maxLength;
    }
}