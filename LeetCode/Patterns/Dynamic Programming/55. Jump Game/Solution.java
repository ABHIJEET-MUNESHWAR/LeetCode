class Solution {
    public boolean canJump(int[] nums) {
        return canJumpRecursion(nums, nums.length, 0);
    }

    private boolean canJumpRecursion(int[] nums, int size, int currentIndex) {
        if (currentIndex == size - 1) {
            return true;
        }
        if (currentIndex >= size) {
            return false;
        }
        for (int i = 1; i <= nums[currentIndex]; i++) {
            if (canJumpRecursion(nums, size, currentIndex + i)) {
                return true;
            }
        }
        return false;
    }
}