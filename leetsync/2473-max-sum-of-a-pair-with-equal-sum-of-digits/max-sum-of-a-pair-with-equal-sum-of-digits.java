class Solution {
    public int maximumSum(int[] nums) {
        int n = nums.length;
        int[] digitSumToNumMap = new int[82];
        int maxSum = -1;
        for (int num : nums) {
            int digitSum = getDigitSum(num);
            if (digitSumToNumMap[digitSum] > 0) {
                maxSum = Math.max(maxSum, num + digitSumToNumMap[digitSum]);
            }
            digitSumToNumMap[digitSum] = Math.max(num, digitSumToNumMap[digitSum]);
        }
        return maxSum;
    }

    public int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}