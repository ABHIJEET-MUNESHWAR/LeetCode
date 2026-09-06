class Solution {
    public int combinationSum4(int[] nums, int target, int n, int[] dp) {
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        if (dp[target] != -1) {
            return dp[target];
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += combinationSum4(nums, target - nums[i], n, dp);
        }
        return dp[target] = count;
    }

    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return combinationSum4(nums, target, n, dp);
    }
}