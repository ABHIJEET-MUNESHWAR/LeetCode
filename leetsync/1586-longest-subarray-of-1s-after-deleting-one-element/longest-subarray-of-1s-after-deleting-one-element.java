class Solution {
    public int longestSubarray(int[] nums) {
        int size = nums.length;
        int maxLength = 0;
        int left = 0;
        int right = 0;
        int zeroCount = 0;
        while (right < size) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left);
            right++;
        }
        return maxLength;
    }
}