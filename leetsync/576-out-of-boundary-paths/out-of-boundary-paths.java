class Solution {
    int mod = 1000000007;
    int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    int[][][] dp;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new int[51][51][51];
        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < 51; j++) {
                for (int k = 0; k < 51; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return solveRecursionMemoization(m, n, maxMove, startRow, startColumn);
    }

    private int solveRecursionMemoization(int m, int n, int maxMove, int startRow, int startColumn) {
        if (startRow < 0 || startColumn < 0 || startRow >= m || startColumn >= n) {
            return 1;
        }
        if (maxMove <= 0) {
            return 0;
        }
        if (dp[startRow][startColumn][maxMove] != -1) {
            return dp[startRow][startColumn][maxMove];
        }
        int result = 0;
        for (int[] direction : directions) {
            result = (result
                    + solveRecursionMemoization(m, n, maxMove - 1, startRow + direction[0], startColumn + direction[1]))
                    % mod;
        }
        return dp[startRow][startColumn][maxMove] = result;
    }
}