class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        return solveTopDown(nums, n, 0);
    }

    public int solveTopDown(int[] nums, int n, int index) {
        if (index >= n) {
            return 0;
        }
        int take = nums[index] + solveTopDown(nums, n, index + 2);
        int skip = solveTopDown(nums, n, index+1);
        return Math.max(take, skip);
    }
}