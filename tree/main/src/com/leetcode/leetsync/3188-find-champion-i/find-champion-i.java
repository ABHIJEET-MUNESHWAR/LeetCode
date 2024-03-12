class Solution {
    public int findChampion(int[][] grid) {

        int row = grid.length;
        int column = grid[0].length;
        for (int i = 0; i < row; i++) {
            int count = 0;
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
                if (count == row - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}