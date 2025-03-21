class Solution {
    public void dfs(int[][] grid, int row, int col, int rows, int cols, int direction) {
        // Boundary check and skipping guarded or walled cells
        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == 1 || grid[row][col] == 2) {
            return;
        }
        grid[row][col] = 3;
        // Continue the DFS in the specified direction
        switch (direction) {
            case 1:
                // Up
                dfs(grid, row - 1, col, rows, cols, direction);
                break;
            case 2:
                // Down
                dfs(grid, row + 1, col, rows, cols, direction);
                break;
            case 3:
                // Left
                dfs(grid, row, col - 1, rows, cols, direction);
                break;
            case 4:
                // Right
                dfs(grid, row, col + 1, rows, cols, direction);
                break;
        }
    }

    public int countUnguarded(int rows, int cols, int[][] guards, int[][] walls) {
        // Initialize the grid
        int[][] grid = new int[rows][cols];
        // Mark guard positions
        for (int[] guard : guards) {
            int i = guard[0];
            int j = guard[1];
            grid[i][j] = 1; // Guard cell
        }
        // Mark wall positions
        for (int[] wall : walls) {
            int i = wall[0];
            int j = wall[1];
            grid[i][j] = 2; // Wall cell
        }

        // Perform DFS for each guard in all four directions (UP, DOWN, LEFT, RIGHT)
        for (int[] guard : guards) {
            int guardRow = guard[0];
            int guardCol = guard[1];
            dfs(grid, guardRow - 1, guardCol, rows, cols, 1); // Up
            dfs(grid, guardRow + 1, guardCol, rows, cols, 2); // Down
            dfs(grid, guardRow, guardCol - 1, rows, cols, 3); // Left
            dfs(grid, guardRow, guardCol + 1, rows, cols, 4); // Right
        }
        // Count unguarded cells
        int unguardedCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    unguardedCount++;
                }
            }
        }
        return unguardedCount;
    }
}