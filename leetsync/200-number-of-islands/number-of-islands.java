class Solution {
    int[][] directions = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

    public int numIslands(char[][] grid) {
        int totalIslands = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, m, n, i, j);
                    totalIslands++;
                }
            }
        }
        return totalIslands;
    }

    public void dfs(char[][] grid, int m, int n, int i, int j) {
        grid[i][j] = '0';
        for (int[] direction : directions) {
            int i_ = i + direction[0];
            int j_ = j + direction[1];
            if (i_ >= 0 && j_ >= 0 && i_ < m && j_ < n && grid[i_][j_] == '1') {
                dfs(grid, m, n, i_, j_);
            }
        }
    }
}