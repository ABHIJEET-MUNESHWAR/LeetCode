class Solution {
    public int topDownFib(int n, int[] dp) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = topDownFib(n - 1, dp) + topDownFib(n - 2, dp);
    }

    public int fib(int n) {
        int[] dp = new int[31];
        Arrays.fill(dp, -1);
        return topDownFib(n, dp);
    }
}