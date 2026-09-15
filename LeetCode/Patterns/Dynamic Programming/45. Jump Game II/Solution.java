class Solution {
    public int jumpRecursion(int[] nums, int n, int index) {
        if (index >= n - 1) {
            return 0;
        }
        int minJumps = Integer.MAX_VALUE;
        int maxJump = nums[index];
        for (int i = 1; i <= maxJump; i++) {
            int jump = jumpRecursion(nums, n, index + i);
            if (jump != Integer.MAX_VALUE) {
                minJumps = Math.min(minJumps, 1 + jump);
            }
        }
        return minJumps;
    }

    public int jump(int[] nums) {
        int n = nums.length;
        return jumpRecursion(nums, n, 0);
    }
}