class Solution {
    public int countHillValley(int[] nums) {
        int count = 0;
        int left = 0, right = 0;
        int n = nums.length;
        while (right + 1 < n) {
            if ((nums[left] > nums[right] && nums[right] < nums[right + 1])
                    || ((nums[left] < nums[right] && nums[right] > nums[right + 1]))) {
                count++;
                left = right;
            }
            right++;
        }
        return count;
    }
}