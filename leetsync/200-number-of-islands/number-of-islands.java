class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    DFSMarking(grid, rows, cols, r, c);
                    count++;
                }
            }
        }
        return count;
    }

    public void DFSMarking(char[][] grid, int rows, int cols, int r, int c) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] != '1') {
            return;
        }
        grid[r][c] = '0';
        DFSMarking(grid, rows, cols, r + 1, c);
        DFSMarking(grid, rows, cols, r - 1, c);
        DFSMarking(grid, rows, cols, r, c + 1);
        DFSMarking(grid, rows, cols, r, c - 1);
    }
}