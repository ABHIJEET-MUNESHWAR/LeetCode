class Solution {
    public int combinationSum4(int[] nums, int target) {
        return solve(nums, target, 0);
    }

    private int solve(int[] nums, int target, int indexs) {
        if (target == 0) {
            return 1;
        }
        if (indexs >= nums.length || target < 0) {
            return 0;
        }
        int take = solve(nums, target - nums[indexs], 0);
        int skip = solve(nums, target, indexs + 1);
        return take + skip;
    }
}