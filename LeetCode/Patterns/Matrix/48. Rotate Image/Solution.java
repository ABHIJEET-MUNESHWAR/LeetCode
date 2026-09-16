class Solution {
    public void rotate(int[][] matrix) {

        // transpose
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = i; j < cols; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // swap
        for (int i = 0; i < rows; i++) {
            for (int j = 0, k = cols - 1; k > j; j++, k--) {
                int temp = matrix[i][k];
                matrix[i][k] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

    }
}