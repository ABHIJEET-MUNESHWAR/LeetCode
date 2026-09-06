class Solution {
    public long maxAlternatingSum(int[] nums) {
        int size = nums.length;
        long[][] dp = new long[size + 1][2];
        dp[0][0] = Math.max(-nums[0], 0);
        dp[0][1] = Math.max(nums[0], 0);
        for (int i = 1; i < size; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - nums[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + nums[i]);
        }
        return Math.max(dp[size - 1][0], dp[size - 1][1]);
    }
}