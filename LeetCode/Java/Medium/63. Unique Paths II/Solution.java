class Solution {
    public int uniquePathsWithObstaclesRecursionMemoization(int[][] obstacleGrid, int m, int n, int i, int j,
            int[][] dp) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (i < 0 || j < 0 || i >= m || j >= n || obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        return dp[i][j] = uniquePathsWithObstaclesRecursionMemoization(obstacleGrid, m, n, i + 1, j, dp)
                + uniquePathsWithObstaclesRecursionMemoization(obstacleGrid, m, n, i, j + 1, dp);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return uniquePathsWithObstaclesRecursionMemoization(obstacleGrid, m, n, 0, 0, dp);
    }
}