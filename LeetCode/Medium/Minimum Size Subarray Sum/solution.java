class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int size = nums.length;
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;
        int left = 0, right = 0;
        while (right < size) {
            currentSum += nums[right];
            // Shrink window
            while (currentSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                currentSum -= nums[left];
                left++;
            }
            // Expand window
            right++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}