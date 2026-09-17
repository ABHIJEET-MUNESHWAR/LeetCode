class Solution {
    public int robRecursion(int[] nums, int n, int index, int[] dp) {
        if (index >= n) {
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
        int[] dp = new int[401];
        Arrays.fill(dp, -1);
        return robRecursion(nums, n, 0, dp);
    }
}