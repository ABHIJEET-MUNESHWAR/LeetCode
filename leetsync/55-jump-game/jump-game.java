class Solution {
    public boolean canJump(int[] nums) {
        int size = nums.length;
        int maxReachable = 0;
        for (int i = 0; i < size; i++) {
            if (i > maxReachable) {
                return false;
            }
            maxReachable = Math.max(maxReachable, nums[i] + i);
        }
        return true;
    }
}