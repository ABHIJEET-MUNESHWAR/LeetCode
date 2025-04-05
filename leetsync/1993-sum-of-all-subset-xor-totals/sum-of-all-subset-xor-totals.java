class Solution {

    public int solve(int[] nums, int index, int xor) {
        if (index >= nums.length) {
            return xor;
        }
        int take = solve(nums, index + 1, nums[index] ^ xor);
        int skip = solve(nums, index + 1, xor);
        return take + skip;
    }

    public int subsetXORSum(int[] nums) {
        return solve(nums, 0, 0);
    }
}