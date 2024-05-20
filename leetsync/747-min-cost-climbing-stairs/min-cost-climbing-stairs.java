class Solution {
    int[] dp = new int[10001];

    public int minCostClimbingStairs(int[] cost) {
        for (int i = 0; i < 10001; i++) {
            dp[i] = -1;
        }
        return Math.min(solve(cost, 0), solve(cost, 1));
    }

    private int solve(int[] cost, int i) {
        if (i >= cost.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int a = cost[i] + solve(cost, i + 1);
        int b = cost[i] + solve(cost, i + 2);
        dp[i] = Math.min(a, b);
        return dp[i];
    }
}