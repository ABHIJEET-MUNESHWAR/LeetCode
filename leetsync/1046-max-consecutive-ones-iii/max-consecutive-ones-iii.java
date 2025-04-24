class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeros = 0, left = 0, right = 0, n = nums.length;
        int maxRange = 0;
        while (right < n) {
            if (nums[right] == 0) {
                zeros++;
            }
            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            maxRange = Math.max(maxRange, right - left + 1);
            right++;
        }
        return maxRange;
    }
}