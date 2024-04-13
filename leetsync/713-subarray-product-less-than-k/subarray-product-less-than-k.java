class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int size = nums.length;
        int count = 0;
        int product = 1;
        int start = 0;
        int end = 0;
        while (end < size) {
            // Expansion
            product *= nums[end];
            // Shrinking
            while (product >= k) {
                // Invalid Window
                product /= nums[start];
                start++;
            }
            count += end - start + 1;
            end++;
        }
        return count;
    }
}