class Solution {
    public boolean solveCanJump(int[] nums, int n, int index, Boolean[] dp) {
        if (index == n - 1) {
            return true;
        }
        if (dp[index] != null) {
            return dp[index];
        }
        for (int i = 1; i <= nums[index]; i++) {
            if (solveCanJump(nums, n, index + i, dp)) {
                return dp[index] = true;
            }
        }
        return dp[index] = false;
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        Boolean[] dp = new Boolean[n];
        return solveCanJump(nums, n, 0, dp);
    }
}