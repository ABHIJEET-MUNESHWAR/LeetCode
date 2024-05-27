class Solution {
    int totalWays = 0;

    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, target, 0, 0);
    }

    private int solve(int[] nums, int target, int index, int currentTotal) {
        if (index >= nums.length) {
            if (currentTotal == target) {
                return 1;
            } else {
                return 0;
            }
        }
        return solve(nums, target, index + 1, currentTotal + nums[index])
                + solve(nums, target, index + 1, currentTotal - nums[index]);
    }
}