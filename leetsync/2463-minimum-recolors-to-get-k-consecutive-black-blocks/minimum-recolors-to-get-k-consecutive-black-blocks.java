class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int minLength = k;
        int left = 0, right = 0;
        int whites = 0;
        while (right < n) {
            char ch = blocks.charAt(right);
            if (ch == 'W') {
                whites++;
            }
            if ((right - left + 1) == k) {
                minLength = Math.min(minLength, whites);
                if (blocks.charAt(left) == 'W') {
                    whites--;
                }
                left++;
            }
            right++;
        }
        return minLength;
    }
}