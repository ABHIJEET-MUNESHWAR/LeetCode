class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        long sum = 0;
        int totalNegatives = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = matrix[i][j];
                if (Math.abs(min) > Math.abs(num)) {
                    min = Math.abs(num);
                }
                if (num < 0) {
                    totalNegatives++;
                }
                sum += Math.abs(num);
            }
        }
        if (totalNegatives % 2 == 0) {
            //
        } else {
            sum -= 2 * min;
        }
        return sum;
    }
}