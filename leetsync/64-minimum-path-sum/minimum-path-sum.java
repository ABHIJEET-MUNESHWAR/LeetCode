class Solution {

    int[][] dp;

    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        dp = new int[rows + 1][cols + 1];
        for (int i = 0; i <= rows; i++) {
            Arrays.fill(dp[i], -1);
        }
        return minPathSumRecursionMemoization(grid, rows, cols, 0, 0);
    }

    private int minPathSumRecursionMemoization(int[][] grid, int rows, int cols, int currentRow, int currentColumn) {
        if (currentRow == rows - 1 && currentColumn == cols - 1) {
            return dp[currentRow][currentColumn] = grid[currentRow][currentColumn];
        }

        if (dp[currentRow][currentColumn] != -1) {
            return dp[currentRow][currentColumn];
        }
        if (currentRow == rows - 1) {
            return dp[currentRow][currentColumn] = grid[currentRow][currentColumn]
                    + minPathSumRecursionMemoization(grid, rows, cols, currentRow, currentColumn + 1);
        } else if (currentColumn == cols - 1) {
            return dp[currentRow][currentColumn] = grid[currentRow][currentColumn]
                    + minPathSumRecursionMemoization(grid, rows, cols, currentRow + 1, currentColumn);
        } else {
            return dp[currentRow][currentColumn] = grid[currentRow][currentColumn]
                    + Math.min(minPathSumRecursionMemoization(grid, rows, cols, currentRow, currentColumn + 1),
                            minPathSumRecursionMemoization(grid, rows, cols, currentRow + 1, currentColumn));
        }
    }
}