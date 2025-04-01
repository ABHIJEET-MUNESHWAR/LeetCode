class Solution {
    public long mostPoints(int[][] q) {
        int n = q.length;
        long[] dp = new long[200001];
        if (n == 1) {
            return q[0][0];
        }
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], q[i][0] + dp[q[i][1] + i + 1]);
        }
        return dp[0];
    }
}