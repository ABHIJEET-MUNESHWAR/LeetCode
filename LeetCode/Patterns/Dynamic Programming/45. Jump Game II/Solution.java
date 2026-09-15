class Solution {
    public int jumpRecursionMemoization(int[] nums, int n, int index, int[] dp) {
        if (index >= n - 1) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int minJumps = Integer.MAX_VALUE;
        int maxJump = nums[index];
        for (int i = 1; i <= maxJump; i++) {
            int jump = jumpRecursionMemoization(nums, n, index + i, dp);
            if (jump != Integer.MAX_VALUE) {
                minJumps = Math.min(minJumps, 1 + jump);
            }
        }
        return dp[index] = minJumps;
    }

    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return jumpRecursionMemoization(nums, n, 0, dp);
    }
}