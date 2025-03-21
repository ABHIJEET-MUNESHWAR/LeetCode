class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col < n; col++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < col; k++) {
                    min = Math.min(min, grid[row + 1][k]);
                }
                for (int k = col + 1; k < n; k++) {
                    min = Math.min(min, grid[row + 1][k]);
                }
                grid[row][col] += min;
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            answer = Math.min(answer, grid[0][col]);
        }
        return answer;
    }
}