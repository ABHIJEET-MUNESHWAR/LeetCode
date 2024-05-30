class Solution {
    public int longestContinuousSubstring(String s) {
        int size = s.length();
        int maxLength = 0;
        int currentLength = 0;
        int left = 0;
        int right = 0;
        while (right < size) {
            while ((right + 1 < size) && ((int) (s.charAt(right) + 1) == (int) (s.charAt(right + 1)))) {
                right++;
            }
            currentLength = right - left + 1;
            maxLength = Math.max(maxLength, currentLength);
            right++;
            left = right;
        }
        return maxLength;
    }
}