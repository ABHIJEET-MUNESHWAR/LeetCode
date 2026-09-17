class Solution {
    public int robRecursion(int[] nums, int n, int index) {
        if (index >= n) {
            return 0;
        }
        int take = nums[index] + robRecursion(nums, n, index + 2);
        int skip = robRecursion(nums, n, index + 1);
        return Math.max(take, skip);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        return robRecursion(nums, n, 0);
    }
}