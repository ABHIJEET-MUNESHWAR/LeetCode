class Solution {
    int[][] dp = new int[201][20001];

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        for (int i = 0; i < 201; i++) {
            Arrays.fill(dp[i], -1);
        }
        return canPartition(nums, 0, sum / 2);
    }

    public boolean canPartition(int[] nums, int index, int target) {
        if (target == 0) {
            return true;
        }
        if (index >= nums.length) {
            return false;
        }
        if (dp[index][target] != -1) {
            return dp[index][target] == 1;
        }
        boolean take = false;
        if (nums[index] <= target) {
            take = canPartition(nums, index + 1, target - nums[index]);
        }
        boolean skip = canPartition(nums, index + 1, target);
        dp[index][target] = (take || skip) ? 1 : 0;
        return take || skip;
    }
}