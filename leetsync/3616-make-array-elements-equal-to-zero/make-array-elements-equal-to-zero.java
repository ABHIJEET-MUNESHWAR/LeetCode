class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int totalSum = 0, result = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int currSum = 0;
        for (int i = 0; i < n; i++) {
            currSum += nums[i];
            int leftSum = currSum;
            int rightSum = totalSum - leftSum;
            if (nums[i] != 0) {
                continue;
            }
            if (leftSum == rightSum) {
                result += 2;
            } else if (Math.abs(leftSum - rightSum) == 1) {
                result++;
            }
        }
        return result;
    }
}