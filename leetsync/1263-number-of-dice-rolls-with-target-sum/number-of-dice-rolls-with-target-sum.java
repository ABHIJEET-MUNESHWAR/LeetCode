class Solution {

    int mod = 1000000007;
    int[][] dp;

    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[32][1002];
        for (int i = 0; i < 32; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solveRecursionMemoization(n, k, target);
    }

    private int solveRecursionMemoization(int n, int k, int target) {
        if (target < 0 || n == 0) {
            return target == 0 ? 1 : 0;
        }
        if (dp[n][target] != -1) {
            return dp[n][target];
        }
        int sum = 0;
        for (int face = 1; face <= k; face++) {
            sum = (sum + solveRecursionMemoization(n - 1, k, target - face)) % mod;
        }
        return dp[n][target] = sum;
    }
}