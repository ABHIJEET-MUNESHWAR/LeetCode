class Solution {
    private final int M = 1000000007; // 1e9 + 7
    private int[][] dp = new int[301][301];

    public int solve(int n, int x, int num) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        int currentPowerValue = (int) Math.pow(num, x);
        if (currentPowerValue > n) {
            return 0;
        }
        if (dp[n][num] != -1) {
            return dp[n][num];
        }
        int take = solve(n - currentPowerValue, x, num + 1);
        int skip = solve(n, x, num + 1);
        return dp[n][num] = (take + skip) % M;
    }

    public int numberOfWays(int n, int x) {
        for (int i = 0; i < 301; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(n, x, 1);
    }
}