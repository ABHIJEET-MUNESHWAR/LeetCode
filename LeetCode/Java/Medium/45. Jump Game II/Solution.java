class Solution {
    public int jump(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return canJumpRecursionMemoization(nums, nums.length, 0, memo);
    }

    private int canJumpRecursionMemoization(int[] nums, int size, int currentIndex, int[] memo) {
        if (currentIndex == size - 1) {
            return 0;
        }
        if (memo[currentIndex] != -1) {
            return memo[currentIndex];
        }
        int minJump = 99999;
        for (int i = currentIndex + 1; (i <= currentIndex + nums[currentIndex] && i < size); i++) {
            int value = 1 + canJumpRecursionMemoization(nums, size, i, memo);
            minJump = Math.min(minJump, value);
        }
        return memo[currentIndex] = minJump;
    }
}