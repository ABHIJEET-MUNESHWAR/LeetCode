class Solution {

    int[][] dp;

    public int strangePrinter(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solveRecursionMemoization(s, left, right);
    }

    private int solveRecursionMemoization(String s, int left, int right) {
        if (left == right) {
            return 1;
        }
        if (left > right) {
            return 0;
        }
        if (dp[left][right] != -1) {
            return dp[left][right];
        }
        int i = left + 1;
        while (i <= right && s.charAt(i) == s.charAt(left)) {
            i++;
        }
        if (i == right + 1) {
            return 1;
        }
        int normal = 1 + solveRecursionMemoization(s, i, right);
        int greedy = Integer.MAX_VALUE;
        for (int j = i; j <= right; j++) {
            if (s.charAt(j) == s.charAt(left)) {
                int x = solveRecursionMemoization(s, i, j - 1) + solveRecursionMemoization(s, j, right);
                greedy = Math.min(greedy, x);
            }
        }
        return dp[left][right] = Math.min(greedy, normal);
    }
}