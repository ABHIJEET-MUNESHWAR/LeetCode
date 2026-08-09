class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[401];
        Arrays.fill(dp, -1);
        return solve(nums, n, 0, dp);
    }

    public int solve(int[] nums, int n, int index, int[] dp) {
        if (index >= n) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int rob = nums[index] + solve(nums, n, index + 2, dp);
        int skip = solve(nums, n, index + 1, dp);
        return dp[index] = Math.max(rob, skip);
    }
}