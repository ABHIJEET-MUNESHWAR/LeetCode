class Solution {
    int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i][j] && dfs(grid, i, j, -1, -1, isVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] grid, int i, int j, int prevI, int prevJ, boolean[][] isVisited) {
        if (isVisited[i][j]) {
            return true;
        }
        isVisited[i][j] = true;

        int m = grid.length;
        int n = grid[0].length;
        for (int[] direction : directions) {
            int i_ = i + direction[0];
            int j_ = j + direction[1];
            if (i_ >= 0 && j_ >= 0 && i_ < m && j_ < n && grid[i_][j_] == grid[i][j]) {
                if (i_ == prevI && j_ == prevJ) {
                    continue;
                }
                if (dfs(grid, i_, j_, i, j, isVisited)) {
                    return true;
                }
            }
        }
        return false;
    }
}