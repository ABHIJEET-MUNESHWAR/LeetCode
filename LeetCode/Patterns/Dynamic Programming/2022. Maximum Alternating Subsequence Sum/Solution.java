class Solution {
    public int maxAlternatingSumRecursion(int[] nums, int n, int index, boolean isEven) {
        if (index >= n) {
            return 0;
        }
        int skip = maxAlternatingSumRecursion(nums, n, index + 1, isEven);
        int val = nums[index];
        if (!isEven) {
            val = -val;
        }
        int take = val + maxAlternatingSumRecursion(nums, n, index + 1, !isEven);
        return Math.max(skip, take);
    }

    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        return maxAlternatingSumRecursion(nums, n, 0, true);
    }
}