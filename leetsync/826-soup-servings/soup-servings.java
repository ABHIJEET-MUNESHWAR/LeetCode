class Solution {

    int[][] serves = { { 100, 0 }, { 75, 25 }, { 50, 50 }, { 25, 75 } };

    double[][] dp;

    public double soupServings(int n) {
        if (n >= 5000) {
            return 1.0;
        }
        dp = new double[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return soupServingsRecursionMemoization(n, n);
    }

    private double soupServingsRecursionMemoization(int a, int b) {
        if (a <= 0 && b <= 0) {
            return 0.5;
        }
        if (a <= 0) {
            return 1.0;
        }
        if (b <= 0) {
            return 0.0;
        }
        if (dp[a][b] != -1) {
            return dp[a][b];
        }
        double probability = 0.0;
        for (int[] serve : serves) {
            probability += 0.25 * (soupServingsRecursionMemoization(a - serve[0], b - serve[1]));
        }
        return dp[a][b] = probability;
    }
}