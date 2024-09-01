class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int size = original.length;
        if (size != m * n) {
            return new int[0][0];
        }
        int[][] result = new int[m][n];
        for (int i = 0; i < size; i++) {
            int row = i / n;
            int col = i % n;
            result[row][col] = original[i];
        }
        return result;
    }
}