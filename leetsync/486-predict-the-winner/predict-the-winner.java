class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return true;
        }
        int totalScore = 0;
        for (int num : nums) {
            totalScore += num;
        }
        int player1Score = solveRecursion(nums, 0, n - 1);
        int player2Score = totalScore - player1Score;
        return player1Score >= player2Score;
    }

    private int solveRecursion(int[] nums, int left, int right) {
        if (left > right) {
            return 0;
        }
        if (left == right) {
            return nums[left];
        }
        int leftScore = nums[left]
                + Math.min(solveRecursion(nums, left + 2, right), solveRecursion(nums, left + 1, right - 1));
        int rightScore = nums[right]
                + Math.min(solveRecursion(nums, left, right - 2), solveRecursion(nums, left + 1, right - 1));
        return Math.max(leftScore, rightScore);
    }
}