class Solution {
    int[][] directions = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };
    int walks = 0;

    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int walkableCells = 0;
        int sourceRow = 0;
        int sourceCol = 0;
        boolean[][] isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != -1) {
                    walkableCells++;
                }
                if (grid[i][j] == 1) {
                    sourceRow = i;
                    sourceCol = j;
                }
            }
        }
        backTrackDFSWalk(grid, sourceRow, sourceCol, walkableCells, isVisited, 1);
        return walks;
    }

    public void backTrackDFSWalk(int[][] grid, int row, int col, int walkableCells, boolean[][] isVisited,
            int totalWalks) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[row][col] == 2) {
            if (totalWalks == walkableCells) {
                walks++;
            }
            return;
        }
        isVisited[row][col] = true;
        for (int[] direction : directions) {
            int i_ = row + direction[0];
            int j_ = col + direction[1];
            if (i_ >= 0 && j_ >= 0 && i_ < m && j_ < n && !isVisited[i_][j_] && grid[i_][j_] != -1) {
                backTrackDFSWalk(grid, i_, j_, walkableCells, isVisited, totalWalks + 1);
            }
        }
        isVisited[row][col] = false;
    }
}