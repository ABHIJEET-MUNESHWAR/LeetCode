class Solution {
    int size;
    int[][] dp = new int[2501][2501];

    public int lengthOfLIS(int[] nums) {
        size = nums.length;
        for (int i = 0; i < 2501; i++) {
            for (int j = 0; j < 2501; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(nums, 0, -1);
    }

    private int solve(int[] nums, int index, int previous) {
        if (previous != -1 && dp[index][previous] != -1) {
            return dp[index][previous];
        }
        if (index >= size) {
            return 0;
        }
        int take = 0;
        if (previous == -1 || nums[previous] < nums[index]) {
            take = 1 + solve(nums, index + 1, index);
        }
        int skip = solve(nums, index + 1, previous);
        if (previous != -1) {
            dp[index][previous] = Math.max(take, skip);
        }
        return Math.max(take, skip);
    }
}