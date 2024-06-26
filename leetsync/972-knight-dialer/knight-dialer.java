class Solution {
    int[][] dp;
    int mod = 1000000007;
    List<List<Integer>> adj = Arrays.asList(
            Arrays.asList(4, 6),
            Arrays.asList(6, 8),
            Arrays.asList(7, 9),
            Arrays.asList(4, 8),
            Arrays.asList(3, 9, 0),
            Arrays.asList(),
            Arrays.asList(1, 7, 0),
            Arrays.asList(2, 6),
            Arrays.asList(1, 3),
            Arrays.asList(2, 4));

    public int knightDialer(int n) {
        int result = 0;
        dp = new int[5001][10];
        for (int i = 0; i < 5001; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int cell = 0; cell <= 9; cell++) {
            result = (result + solveRecursionMemoization(n - 1, cell)) % mod;
        }
        return result;
    }

    private int solveRecursionMemoization(int n, int cell) {
        if (n <= 0) {
            return 1;
        }
        if (dp[n][cell] != -1) {
            return dp[n][cell];
        }
        int result = 0;
        for (int neighbor : adj.get(cell)) {
            result = (result + solveRecursionMemoization(n - 1, neighbor)) % mod;
        }
        return dp[n][cell] = result;
    }
}