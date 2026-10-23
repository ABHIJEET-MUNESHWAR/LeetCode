class Solution {
    public int robRecursive(int[] nums, int n, int index) {
        if (index >= n) {
            return 0;
        }
        int take = nums[index] + robRecursive(nums, n, index + 2);
        int skip = robRecursive(nums, n, index + 1);
        return Math.max(take, skip);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        return robRecursive(nums, n, 0);
    }
}