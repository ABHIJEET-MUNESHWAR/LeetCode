class Solution {
    public int solve(int[] nums, int target, int index, int currentSum) {
        if (index == nums.length) {
            if (currentSum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        int plus = solve(nums, target, index + 1, currentSum + nums[index]);
        int minus = solve(nums, target, index + 1, currentSum - nums[index]);
        return plus + minus;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return solve(nums, target, 0, 0);
    }
}