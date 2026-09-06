class Solution {
    int size;

    public int lengthOfLIS(int[] nums) {
        size = nums.length;
        return solve(nums, 0, -1);
    }

    private int solve(int[] nums, int index, int previous) {
        if (index >= size) {
            return 0;
        }
        int take = 0;
        if (previous == -1 || nums[previous] < nums[index]) {
            take = 1 + solve(nums, index + 1, index);
        }
        int skip = solve(nums, index + 1, previous);
        return Math.max(take, skip);
    }
}