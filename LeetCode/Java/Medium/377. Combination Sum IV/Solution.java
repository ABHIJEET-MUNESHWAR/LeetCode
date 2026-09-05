class Solution {
    int[][] dp;

    public int combinationSum4(int[] nums, int target) {
        dp = new int[nums.length][target + 1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solveRecursionMemoization(nums, target, 0);
    }

    private int solveRecursionMemoization(int[] nums, int target, int index) {
        if (target == 0) {
            return 1;
        }
        if (index >= nums.length || target < 0) {
            return 0;
        }
        if (dp[index][target] != -1) {
            return dp[index][target];
        }
        int take = solveRecursionMemoization(nums, target - nums[index], 0);
        int skip = solveRecursionMemoization(nums, target, index + 1);
        return dp[index][target] = (take + skip);
    }
}