class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length;
        int cols = colSum.length;
        int[][] matrix = new int[rows][cols];
        int i = 0, j = 0;
        while (i < rows && j < cols) {
            matrix[i][j] = Math.min(rowSum[i], colSum[j]);
            rowSum[i] -= matrix[i][j];
            colSum[j] -= matrix[i][j];
            if (rowSum[i] == 0) {
                i++;
            }
            if (colSum[j] == 0) {
                j++;
            }
        }
        return matrix;
    }

    private int minIndex(int[] rowSum, Set<Integer> rowSumSet) {
        int minIndex = Integer.MAX_VALUE;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < rowSum.length; i++) {
            if (minValue > rowSum[i] && !rowSumSet.contains(i)) {
                minValue = rowSum[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}