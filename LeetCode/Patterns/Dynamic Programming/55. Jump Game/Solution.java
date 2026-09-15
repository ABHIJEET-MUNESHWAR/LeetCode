class Solution {
    public boolean canJump(int[] nums) {
        Boolean[] memo = new Boolean[nums.length];
        return canJumpRecursionMemoization(nums, nums.length, 0, memo);
    }

    private boolean canJumpRecursionMemoization(int[] nums, int length, int index, Boolean[] memo) {
        if (index >= length - 1) {
            return true;
        }
        if (memo[index] != null) {
            return memo[index];
        }
        memo[index] = false;
        for (int step = nums[index]; step > 0; step--) {
            if (canJumpRecursionMemoization(nums, length, index + step, memo)) {
                return memo[index] = true;
            }
        }
        return memo[index];
    }
}