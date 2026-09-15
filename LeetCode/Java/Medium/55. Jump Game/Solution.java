class Solution {
    public boolean canJumpRecursion(int[] nums, int n, int index) {
        if (index == (n - 1)) {
            return true;
        }
        if (index >= n) {
            return false;
        }
        for (int i = 1; i <= nums[index]; i++) {
            if (canJumpRecursion(nums, n, index + i)) {
                return true;
            }
        }
        return false;
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        return canJumpRecursion(nums, n, 0);
    }
}