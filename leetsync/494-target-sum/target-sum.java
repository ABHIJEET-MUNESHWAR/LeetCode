class Solution {
    int totalWays = 0;

    public int findTargetSumWays(int[] nums, int target) {
        solve(nums, target, 0, 0);
        return totalWays;
    }

    private void solve(int[] nums, int target, int index, int currentTotal) {
        if (index == nums.length) {
            if (currentTotal == target) {
                totalWays++;
            }
            return;
        }
        solve(nums, target, index + 1, currentTotal + nums[index]);
        solve(nums, target, index + 1, currentTotal - nums[index]);
    }
}