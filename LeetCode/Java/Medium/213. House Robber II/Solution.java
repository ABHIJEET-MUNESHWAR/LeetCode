class Solution {
    public int robRecursion(int[] nums, int n, int index) {
        if (index > n) {
            return 0;
        }
        int take = nums[index] + robRecursion(nums, n, index + 2);
        int skip = robRecursion(nums, n, index + 1);
        return Math.max(take, skip);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int take0thIndexHouse = robRecursion(nums, n - 2, 0);
        int take1stIndexHouse = robRecursion(nums, n - 1, 1);
        return Math.max(take0thIndexHouse, take1stIndexHouse);
    }
}