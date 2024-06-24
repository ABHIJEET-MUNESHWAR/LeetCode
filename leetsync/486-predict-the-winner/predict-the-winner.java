class Solution {
    int[][] dp;

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return true;
        }
        dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int totalScore = 0;
        for (int num : nums) {
            totalScore += num;
        }
        int player1Score = solveRecursionMemoization(nums, 0, n - 1);
        int player2Score = totalScore - player1Score;
        return player1Score >= player2Score;
    }

    private int solveRecursionMemoization(int[] nums, int left, int right) {
        if (left > right) {
            return 0;
        }
        if (left == right) {
            return nums[left];
        }
        if (dp[left][right] != -1) {
            return dp[left][right];
        }
        int leftScore = nums[left] + Math.min(solveRecursionMemoization(nums, left + 2, right),
                solveRecursionMemoization(nums, left + 1, right - 1));
        int rightScore = nums[right] + Math.min(solveRecursionMemoization(nums, left, right - 2),
                solveRecursionMemoization(nums, left + 1, right - 1));
        return dp[left][right] = Math.max(leftScore, rightScore);
    }
}