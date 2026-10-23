class Solution {
    public int lengthOfLIS(int[] nums, int n, int index, int prev) {
        if (index >= n) {
            return 0;
        }
        int take = 0;
        if (prev == -1 || (nums[prev] < nums[index])) {
            take = 1 + lengthOfLIS(nums, n, index + 1, index);
        }
        int skip = lengthOfLIS(nums, n, index + 1, prev);
        return Math.max(take, skip);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        return lengthOfLIS(nums, n, 0, -1);
    }
}