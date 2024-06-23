class Solution {

    int[][] dp;

    public int longestArithSeqLength(int[] nums) {
        int size = nums.length;

        if (size <= 2) {
            return size;
        }
        dp = new int[1001][1005];
        for (int i = 0; i < 1001; i++) {
            Arrays.fill(dp[i], -1);
        }
        int result = 0;
        for (int i = 1; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int diff = nums[j] - nums[i];
                result = Math.max(result, 2 + solveRecursionMemoization(nums, i, diff));
            }
        }
        return result;
    }

    private int solveRecursionMemoization(int[] nums, int index, int diff) {
        int result = 0;
        if (index < 0) {
            return 0;
        }
        if (dp[index][diff + 501] != -1) {
            return dp[index][diff + 501];
        }
        for (int k = index - 1; k >= 0; k--) {
            if ((nums[index] - nums[k]) == diff) {
                result = Math.max(result, 1 + solveRecursionMemoization(nums, k, diff));
            }
        }
        return dp[index][diff + 501] = result;
    }
}