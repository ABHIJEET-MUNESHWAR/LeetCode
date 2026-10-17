class Solution {
    public int climbStairsRecursionMemoization(int n, int[] dp) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = climbStairsRecursionMemoization(n - 1, dp) + climbStairsRecursionMemoization(n - 2, dp);
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return climbStairsRecursionMemoization(n, dp);
    }
}