class Solution {
    public int robRecursion(int[] nums, int n, int index, int[] dp) {
        if (index > n) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int take = nums[index] + robRecursion(nums, n, index + 2, dp);
        int skip = robRecursion(nums, n, index + 1, dp);
        return dp[index] = Math.max(take, skip);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[101];
        Arrays.fill(dp, -1);
        int take0thIndexHouse = robRecursion(nums, n - 2, 0, dp);
        Arrays.fill(dp, -1);
        int take1stIndexHouse = robRecursion(nums, n - 1, 1, dp);
        return Math.max(take0thIndexHouse, take1stIndexHouse);
    }
}