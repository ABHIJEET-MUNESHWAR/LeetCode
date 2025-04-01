class Solution {
    public long solve(int[][] q, int index, long[] dp) {
        if (index >= q.length) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        long take = q[index][0] + solve(q, index + q[index][1] + 1, dp);
        long skip = solve(q, index + 1, dp);
        return dp[index] = Math.max(take, skip);
    }

    public long mostPoints(int[][] q) {
        int n = q.length;
        long[] dp = new long[n];
        Arrays.fill(dp, -1);
        return solve(q, 0, dp);
    }
}