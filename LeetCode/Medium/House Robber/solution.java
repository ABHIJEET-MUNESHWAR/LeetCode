class Solution {
    public int robRecursionMemoization(int[] nums, int n, int index, int[] dp) {
        if (index >= n) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int take = nums[index] + robRecursionMemoization(nums, n, index + 2, dp);
        int skip = robRecursionMemoization(nums, n, index + 1, dp);
        return dp[index] = Math.max(take, skip);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return robRecursionMemoization(nums, n, 0, dp);
    }
}