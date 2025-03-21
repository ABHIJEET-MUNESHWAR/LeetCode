class Solution {
    int mod = 1000000007;
    int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove + 1];
        for (int k = 1; k <= maxMove; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] direction : directions) {
                        int x = i + direction[0];
                        int y = j + direction[1];
                        if (x < 0 || y < 0 || x >= m || y >= n) {
                            dp[i][j][k] = (dp[i][j][k] + 1) % mod;
                        } else {
                            dp[i][j][k] = (dp[i][j][k] + dp[x][y][k - 1]) % mod;
                        }
                    }
                }
            }
        }
        return dp[startRow][startColumn][maxMove];
    }
}