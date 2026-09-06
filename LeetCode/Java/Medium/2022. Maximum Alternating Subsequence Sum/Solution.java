class Solution {
    public long maxAlternatingSum(int[] nums) {
        return solve(nums, 0, true);
    }

    private int solve(int[] nums, int index, boolean isEven) {
        if (index >= nums.length) {
            return 0;
        }
        int skip = solve(nums, index + 1, isEven);
        int value = nums[index];
        if (!isEven) {
            value = -value;
        }
        int take = solve(nums, index + 1, !isEven) + value;
        return Math.max(take, skip);
    }
}