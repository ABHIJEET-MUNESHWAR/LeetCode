class Solution {

    double[][] dp;

    public double champagneTower(int poured, int queryRow, int queryGlass) {
        double[][] dp = new double[101][101];
        dp[0][0] = poured;
        for (int row = 0; row <= queryRow; row++) {
            for (int col = 0; col <= row; col++) {
                double extra = (dp[row][col] - 1) / 2;
                if (extra > 0) {
                    dp[row + 1][col + 1] += extra;
                    dp[row + 1][col] += extra;
                }
            }
        }
        return Math.min(1, dp[queryRow][queryGlass]);
    }
}