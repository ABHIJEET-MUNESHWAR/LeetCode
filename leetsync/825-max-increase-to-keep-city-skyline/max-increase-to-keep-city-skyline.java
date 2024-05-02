class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {

        int answer = 0;
        int n = grid.length;
        int[] rowMaxArray = new int[n];
        int[] colMaxArray = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowMaxArray[i] = Math.max(rowMaxArray[i], grid[i][j]);
                colMaxArray[j] = Math.max(colMaxArray[j], grid[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int raise = Math.min(rowMaxArray[i], colMaxArray[j]) - grid[i][j];
                answer += raise;
            }
        }
        return answer;
    }
}