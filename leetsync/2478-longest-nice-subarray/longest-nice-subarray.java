class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int left = 0, right = 0, result = 1, mask = 0;
        while (right < n) {
            while ((mask & nums[right]) != 0) {
                mask = (mask ^ nums[left]);
                left++;
            }
            result = Math.max(result, right - left + 1);
            mask = (mask | nums[right]);
            right++;
        }
        return result;
    }
}