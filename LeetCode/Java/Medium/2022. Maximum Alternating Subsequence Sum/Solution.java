class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[][] dp = new long[nums.length + 1][2]; // in each row we save the value and its flag value
        for (int i = 0; i <= nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solveRecursionMemoization(nums, 0, 1, dp);
    }

    private long solveRecursionMemoization(int[] nums, int index, int isEven, long[][] dp) {
        if (index >= nums.length) {
            return 0;
        }
        if (dp[index][isEven] != -1) {
            return dp[index][isEven];
        }
        long skip = solveRecursionMemoization(nums, index + 1, isEven, dp);
        int value = nums[index];
        if (isEven == 0) {
            value = -value;
        }
        long take = solveRecursionMemoization(nums, index + 1, 1 - isEven, dp) + value;
        return dp[index][isEven] = Math.max(take, skip);
    }
}