class Solution {

    int mod = 1000000007;

    int[] dp;

    public int numTilings(int n) {
        dp = new int[1001];
        Arrays.fill(dp, -1);
        return numTilingsRecursionAndMemoization(n);
    }

    private int numTilingsRecursionAndMemoization(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        if (n == 3) {
            return 5;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = (2 * numTilingsRecursionAndMemoization(n - 1) % mod
                + numTilingsRecursionAndMemoization(n - 3) % mod) % mod;
    }
}