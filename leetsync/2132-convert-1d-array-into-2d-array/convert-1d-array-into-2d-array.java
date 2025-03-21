class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int size = original.length;
        if (size != m * n) {
            return new int[0][0];
        }
        int[][] result = new int[m][n];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = original[index];
                index++;
            }
        }
        return result;
    }
}