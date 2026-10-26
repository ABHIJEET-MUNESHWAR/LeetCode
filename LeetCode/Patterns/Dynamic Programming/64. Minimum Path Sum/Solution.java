class Solution {
    public int minPathSum(int[][] grid) {
        return minPathSumRecursion(grid, grid.length, grid[0].length, 0, 0);
    }

    private int minPathSumRecursion(int[][] grid, int rows, int cols, int currentRow, int currentColumn) {
        if (currentRow == rows - 1 && currentColumn == cols - 1) {
            return grid[currentRow][currentColumn];
        }
        if (currentRow == rows - 1) {
            return grid[currentRow][currentColumn]
                    + minPathSumRecursion(grid, rows, cols, currentRow, currentColumn + 1);
        } else if (currentColumn == cols - 1) {
            return grid[currentRow][currentColumn]
                    + minPathSumRecursion(grid, rows, cols, currentRow + 1, currentColumn);
        } else {
            return grid[currentRow][currentColumn]
                    + Math.min(minPathSumRecursion(grid, rows, cols, currentRow, currentColumn + 1),
                            minPathSumRecursion(grid, rows, cols, currentRow + 1, currentColumn));
        }
    }
}