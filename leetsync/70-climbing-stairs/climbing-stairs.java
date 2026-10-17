class Solution {
    public int climbStairsRecursive(int n, int[] dp) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = climbStairsRecursive(n - 1, dp) + climbStairsRecursive(n - 2, dp);
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return climbStairsRecursive(n, dp);
    }
}