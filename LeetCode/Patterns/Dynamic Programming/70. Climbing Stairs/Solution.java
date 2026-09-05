class Solution {
    public int climbStairsRecursion(int n, int[] dp) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = climbStairsRecursion(n - 1, dp) + climbStairsRecursion(n - 2, dp);
    }

    public int climbStairs(int n) {
        int[] dp = new int[46];
        Arrays.fill(dp, -1);
        return climbStairsRecursion(n, dp);
    }
}