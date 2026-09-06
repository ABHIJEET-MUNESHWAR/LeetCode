class Solution {
    public int lengthOfLISRecursion(int[] nums, int n, int currentIndex, int previousIndex) {
        if (currentIndex >= n) {
            return 0;
        }
        int take = 0;
        if (previousIndex == -1 || nums[previousIndex] < nums[currentIndex]) {
            take = 1 + lengthOfLISRecursion(nums, n, currentIndex + 1, currentIndex);
        }
        int skip = lengthOfLISRecursion(nums, n, currentIndex + 1, previousIndex);
        return Math.max(take, skip);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        return lengthOfLISRecursion(nums, n, 0, -1);
    }
}