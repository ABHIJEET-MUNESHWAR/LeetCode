class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int start, int end) {
        int prevPrev = 0;
        int prev = 0;

        for (int i = start; i <= end; i++) {
            int steal = nums[i] + prevPrev;
            int skip = prev;
            int temp = Math.max(steal, skip);
            prevPrev = prev;
            prev = temp;
        }

        return prev;
    }
}