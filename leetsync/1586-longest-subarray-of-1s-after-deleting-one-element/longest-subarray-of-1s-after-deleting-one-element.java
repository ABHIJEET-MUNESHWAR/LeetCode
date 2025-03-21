class Solution {
    public int longestSubarray(int[] nums) {
        int size = nums.length;
        int maxLength = 0;
        int lastZeroIndex = -1;
        int left = 0;
        int right = 0;
        while (right < size) {
            if (nums[right] == 0) {
                left = lastZeroIndex + 1;
                lastZeroIndex = right;
            }
            maxLength = Math.max(maxLength, right - left);
            right++;
        }
        return maxLength;
    }
}