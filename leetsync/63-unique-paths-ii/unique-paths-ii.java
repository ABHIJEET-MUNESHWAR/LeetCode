class Solution {
    int[][] dp;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if (obstacleGrid[row - 1][col - 1] == 1) {
            return 0;
        }
        dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solveRecursionMemoization(obstacleGrid, 0, 0);
    }

    private int solveRecursionMemoization(int[][] obstacleGrid, int i, int j) {
        if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) {
            return 1;
        }
        if (i < 0 || i >= obstacleGrid.length || j < 0 || j >= obstacleGrid[0].length || obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        return dp[i][j] = solveRecursionMemoization(obstacleGrid, i + 1, j)
                + solveRecursionMemoization(obstacleGrid, i, j + 1);
    }
}