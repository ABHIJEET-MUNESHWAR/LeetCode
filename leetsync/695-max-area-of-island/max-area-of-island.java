class Solution {
    int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, m, n, i, j));
                }
            }
        }
        return maxArea == Integer.MIN_VALUE ? 0 : maxArea;
    }

    public int dfs(int[][] grid, int m, int n, int i, int j) {
        grid[i][j] = 0;
        int area = 1;
        for (int[] direction : directions) {
            int i_ = i + direction[0];
            int j_ = j + direction[1];
            if (i_ >= 0 && j_ >= 0 && i_ < m && j_ < n && grid[i_][j_] == 1) {
                area += dfs(grid, m, n, i_, j_);
            }
        }
        return area;
    }
}