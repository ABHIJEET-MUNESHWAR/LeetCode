class Solution {
    public boolean validPartition(int[] nums) {
        return solveRecursionMemoization(nums, 0, new Boolean[nums.length]);
    }

    private boolean solveRecursionMemoization(int[] nums, int index, Boolean[] dp) {
        if (index >= nums.length) {
            return true;
        }
        if (dp[index] != null) {
            return dp[index];
        }
        boolean result = false;
        if (index + 1 < nums.length && nums[index + 1] == nums[index]) {
            result = result | solveRecursionMemoization(nums, index + 2, dp);
        }
        if (index + 2 < nums.length && nums[index + 1] == nums[index] && nums[index + 1] == nums[index + 2]) {
            result = result | solveRecursionMemoization(nums, index + 3, dp);
        }
        if (index + 2 < nums.length && (nums[index + 1] - nums[index] == 1)
                && (nums[index + 2] - nums[index + 1] == 1)) {
            result = result | solveRecursionMemoization(nums, index + 3, dp);
        }
        return dp[index] = result;
    }
}