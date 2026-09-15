class Solution {
    public int jump(int[] nums) {
        return canJumpRecursion(nums, nums.length, 0);
    }

    private int canJumpRecursion(int[] nums, int size, int currentIndex) {
        if (currentIndex == size - 1) {
            return 0;
        }
        int minJump = 99999;
        int jump = nums[currentIndex];
        for (int i = currentIndex + 1; (i <= currentIndex + nums[currentIndex] && i < size); i++) {
            int value = 1 + canJumpRecursion(nums, size, i);
            minJump = Math.min(minJump, value);
        }
        return minJump;
    }
}