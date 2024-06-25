class Solution {
    int[] dp;

    public int integerBreak(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solveRecursionMemoization(n);
    }

    private int solveRecursionMemoization(int n) {
        if (n == 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= n - 1; i++) {
            int product = i * Math.max(n - i, solveRecursionMemoization(n - i));
            result = Math.max(result, product);
        }
        return dp[n] = result;
    }
}