class Solution {
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int maxLength = 0;
        long powerValue = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                maxLength++;
            } else if (powerValue <= k) {
                maxLength++;
                k -= powerValue;
            }
            if (powerValue <= k) {
                powerValue <<= 1;// powerValue *= 2
            }
        }
        return maxLength;
    }
}