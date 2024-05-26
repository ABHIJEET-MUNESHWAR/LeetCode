class Solution {
    public int checkRecord(int n) {
        for (int i = 0; i < 100001; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(n, 0, 0);
    }

    int mod = 1000000007;
    int[][][] dp = new int[100001][2][3];

    private int solve(int n, int absent, int consecutiveLate) {
        // Pruning i.e. ignoring meaningless cases
        if (absent > 1 || consecutiveLate > 2) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (dp[n][absent][consecutiveLate] != -1) {
            return dp[n][absent][consecutiveLate];
        }
        int absentCount = solve(n - 1, absent + 1, 0) % mod;
        int lateCount = solve(n - 1, absent, consecutiveLate + 1) % mod;
        int presentCount = solve(n - 1, absent, 0) % mod;
        return dp[n][absent][consecutiveLate] = ((absentCount + lateCount) % mod + presentCount) % mod;
    }
}