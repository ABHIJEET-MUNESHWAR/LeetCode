class Solution {
    private void sortDiagonal(int row, int col, int[][] grid, boolean asc) {
        int n = grid.length;
        List<Integer> array = new ArrayList<>();
        int i = row, j = col;
        while (i < n && j < n) {
            array.add(grid[i][j]);
            i++;
            j++;
        }
        if (asc) {
            Collections.sort(array); // Ascending
        } else {
            array.sort(Collections.reverseOrder()); // Descending
        }
        i = row;
        j = col;
        for (int val : array) {
            grid[i][j] = val;
            i++;
            j++;
        }
    }

    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        // Bottom-left diagonals → sort in non-increasing order
        for (int row = 0; row < n; row++) {
            sortDiagonal(row, 0, grid, false);
        }

        // Top-right diagonals → sort in non-decreasing order
        for (int col = 1; col < n; col++) {
            sortDiagonal(0, col, grid, true);
        }

        return grid;
    }
}