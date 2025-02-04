class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0], currentSum = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) {
                currentSum += nums[i];
            } else {
                currentSum = nums[i];
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}