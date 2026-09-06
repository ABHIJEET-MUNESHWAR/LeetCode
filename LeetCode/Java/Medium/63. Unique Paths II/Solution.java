class Solution {
    public int uniquePathsWithObstaclesRecursion(int[][] obstacleGrid, int m, int n, int i, int j) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (i < 0 || j < 0 || i >= m || j >= n || obstacleGrid[i][j] == 1) {
            return 0;
        }
        return uniquePathsWithObstaclesRecursion(obstacleGrid, m, n, i + 1, j)
                + uniquePathsWithObstaclesRecursion(obstacleGrid, m, n, i, j + 1);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return uniquePathsWithObstaclesRecursion(obstacleGrid, m, n, 0, 0);
    }
}