class Solution {
    public boolean canJumpRecursion(int[] nums, int n, int index, Boolean[] dp) {
        if (index == (n - 1)) {
            return true;
        }
        if (index >= n) {
            return false;
        }
        if (dp[index] != null) {
            return dp[index];
        }
        for (int i = 1; i <= nums[index]; i++) {
            if (canJumpRecursion(nums, n, index + i, dp)) {
                return dp[index] = true;
            }
        }
        return dp[index] = false;
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        Boolean[] dp = new Boolean[n + 1];
        return canJumpRecursion(nums, n, 0, dp);
    }
}