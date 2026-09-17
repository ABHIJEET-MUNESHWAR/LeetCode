class Solution {
    public int lengthOfLISRecursionMemoization(int[] nums, int n, int currentIndex, int previousIndex, int[][] dp) {
        if (currentIndex >= n) {
            return 0;
        }
        if (previousIndex != -1 && dp[currentIndex][previousIndex] != -1) {
            return dp[currentIndex][previousIndex];
        }
        int take = 0;
        if (previousIndex == -1 || nums[previousIndex] < nums[currentIndex]) {
            take = 1 + lengthOfLISRecursionMemoization(nums, n, currentIndex + 1, currentIndex, dp);
        }
        int skip = lengthOfLISRecursionMemoization(nums, n, currentIndex + 1, previousIndex, dp);
        if (previousIndex != -1) {
            dp[currentIndex][previousIndex] = Math.max(take, skip);
        }
        return Math.max(take, skip);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return lengthOfLISRecursionMemoization(nums, n, 0, -1, dp);
    }
}