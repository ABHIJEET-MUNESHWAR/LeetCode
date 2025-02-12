class Solution {
    public int maximumSum(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> digitSumToNumMap = new HashMap<>();
        int maxSum = -1;
        for (int num : nums) {
            int digitSum = getDigitSum(num);
            if (digitSumToNumMap.containsKey(digitSum)) {
                maxSum = Math.max(maxSum, num + digitSumToNumMap.get(digitSum));
            }
            digitSumToNumMap.put(digitSum, Math.max(num, digitSumToNumMap.getOrDefault(digitSum, 0)));
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