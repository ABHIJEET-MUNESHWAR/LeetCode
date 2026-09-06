class Solution {
    public long maxAlternatingSumRecursion(int[] nums, int n, int index, int isEven, long[][] dp) {
        if (index >= n) {
            return 0;
        }
        if (dp[index][isEven] != -1) {
            return dp[index][isEven];
        }
        long skip = maxAlternatingSumRecursion(nums, n, index + 1, isEven, dp);
        int val = nums[index];
        if (isEven == 0) {
            val = -val;
        }
        long take = val + maxAlternatingSumRecursion(nums, n, index + 1, 1 - isEven, dp);
        return dp[index][isEven] = Math.max(skip, take);
    }

    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n + 1][2];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return maxAlternatingSumRecursion(nums, n, 0, 1, dp);
    }
}