class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    result += dfs(grid1, grid2, i, j);
                }
            }
        }
        return result;
    }

    private int dfs(int[][] grid1, int[][] grid2, int i, int j) {
        int m = grid1.length;
        int n = grid1[0].length;
        int result = 1;
        if (i < 0 || i == m || j < 0 || j == n || grid2[i][j] == 0) {
            return 1;
        }
        grid2[i][j] = 0;
        result &= dfs(grid1, grid2, i - 1, j);
        result &= dfs(grid1, grid2, i + 1, j);
        result &= dfs(grid1, grid2, i, j - 1);
        result &= dfs(grid1, grid2, i, j + 1);
        return result & grid1[i][j];
    }
}