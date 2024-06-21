class Solution {

    long[] dp;

    public long mostPoints(int[][] questions) {
        dp = new long[questions.length + 1];
        Arrays.fill(dp, -1L);
        return solveRecursionMemoization(questions, 0);
    }

    private long solveRecursionMemoization(int[][] questions, int index) {
        if (index >= questions.length) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        long take = questions[index][0] + solveRecursionMemoization(questions, index + questions[index][1] + 1);
        long skip = solveRecursionMemoization(questions, index + 1);
        return dp[index] = Math.max(take, skip);
    }
}