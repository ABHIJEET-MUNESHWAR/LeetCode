class Solution {
    public int lengthOfLISRecursion(int[] nums, int n, int index, int previousIndex) {
        if (index >= n) {
            return 0;
        }
        int take = 0;
        if (previousIndex == -1 || (nums[previousIndex] < nums[index])) {
            take = 1 + lengthOfLISRecursion(nums, n, index + 1, index);
        }
        int skip = lengthOfLISRecursion(nums, n, index + 1, previousIndex);
        return Math.max(take, skip);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        return lengthOfLISRecursion(nums, n, 0, -1);
    }
}