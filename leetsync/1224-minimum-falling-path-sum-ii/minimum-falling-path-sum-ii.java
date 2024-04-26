class Solution {
    public int minFallingPathSum(int[][] arr) {
        int n = arr.length;
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col < n; col++) {
                int min = Integer.MAX_VALUE;
                // Values to the left.
                for (int k = 0; k < col; k++) {
                    min = Math.min(arr[row + 1][k], min);
                }
                // Values to the right.
                for (int k = col + 1; k < n; k++) {
                    min = Math.min(arr[row + 1][k], min);
                }
                arr[row][col] += min;
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            result = Math.min(result, arr[0][i]);
        }
        return result;
    }
}