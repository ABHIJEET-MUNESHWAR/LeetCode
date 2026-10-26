class Solution {
    public int minPathSum(int[][] grid, int m, int n, int i, int j) {
        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }
        if (i == m - 1) {
            return grid[i][j] + minPathSum(grid, m, n, i, j + 1);
        } else if (j == n - 1) {
            return grid[i][j] + minPathSum(grid, m, n, i + 1, j);
        } else {
            return grid[i][j] + Math.min(minPathSum(grid, m, n, i, j + 1), minPathSum(grid, m, n, i + 1, j));
        }
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        return minPathSum(grid, m, n, 0, 0);
    }
}