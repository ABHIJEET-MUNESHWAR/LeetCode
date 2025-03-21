class Solution {
    public int subsetXORSum(int[] nums) {
        return solve(nums, 0, 0);
    }

    public int solve(int[] nums, int index, int currentXOR) {
        if (index == nums.length) {
            return currentXOR;
        }
        int includeSum = solve(nums, index + 1, currentXOR ^ nums[index]);
        int excludeSum = solve(nums, index + 1, currentXOR);
        return includeSum + excludeSum;
    }
}