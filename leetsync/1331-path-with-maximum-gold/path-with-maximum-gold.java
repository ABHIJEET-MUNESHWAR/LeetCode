class Solution {
    public int getMaximumGold(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxGold = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] != 0) {
                    maxGold = Math.max(maxGold, dfs(row, col, grid));
                }
            }
        }
        return maxGold;
    }

    private int dfs(int row, int col, int[][] grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }
        int currentCellValue = grid[row][col];
        grid[row][col] = 0;
        int answer = currentCellValue;
        int dfsAnswer = 0;
        dfsAnswer = Math.max(dfsAnswer, dfs(row - 1, col, grid));
        dfsAnswer = Math.max(dfsAnswer, dfs(row + 1, col, grid));
        dfsAnswer = Math.max(dfsAnswer, dfs(row, col - 1, grid));
        dfsAnswer = Math.max(dfsAnswer, dfs(row, col + 1, grid));
        answer += dfsAnswer;
        grid[row][col] = currentCellValue;
        return answer;
    }
}