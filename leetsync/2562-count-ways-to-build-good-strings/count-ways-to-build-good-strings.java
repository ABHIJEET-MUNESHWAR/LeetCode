class Solution {
    int mod = 1000000007;
    int[] dp;

    public int countGoodStrings(int low, int high, int zero, int one) {
        dp = new int[1000001];
        Arrays.fill(dp, -1);
        return solveRecursionMemoization(low, high, zero, one, 0);
    }

    private int solveRecursionMemoization(int low, int high, int zero, int one, int currentStringSize) {
        if (currentStringSize > high) {
            return 0;
        }
        if (dp[currentStringSize] != -1) {
            return dp[currentStringSize];
        }
        int addOne = 0;
        if (currentStringSize >= low && currentStringSize <= high) {
            addOne = 1;
        }
        int appendZero = solveRecursionMemoization(low, high, zero, one, currentStringSize + zero);
        int appendOne = solveRecursionMemoization(low, high, zero, one, currentStringSize + one);
        return dp[currentStringSize] = (addOne + appendZero + appendOne) % mod;
    }
}