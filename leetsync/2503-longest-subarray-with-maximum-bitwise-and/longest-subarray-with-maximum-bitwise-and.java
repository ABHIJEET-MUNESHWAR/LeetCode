class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int maxLength = 0;
        int maxValue = 0, streak = 0;
        for (int num : nums) {
            if (maxValue < num) {
                maxValue = num;
                streak = 0;
                maxLength = 0;
            }
            if (maxValue == num) {
                streak++;
            } else {
                streak = 0;
            }
            maxLength = Math.max(maxLength, streak);
        }
        return maxLength;
    }
}