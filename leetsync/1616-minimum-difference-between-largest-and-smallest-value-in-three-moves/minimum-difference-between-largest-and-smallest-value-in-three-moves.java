class Solution {
    public int minDifference(int[] nums) {
        int size = nums.length;
        if (size < 5) {
            return 0;
        }
        Arrays.sort(nums);
        int minDifference = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            minDifference = Math.min(minDifference, Math.abs(nums[i] - nums[size + i - 4]));
        }
        return minDifference;
    }
}