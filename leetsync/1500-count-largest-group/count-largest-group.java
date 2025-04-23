class Solution {
    public int getDigitSum(int n) {
        int digitSum = 0;
        while (n > 0) {
            digitSum += n % 10;
            n = n / 10;
        }
        return digitSum;
    }

    public int countLargestGroup(int n) {
        Map<Integer, Integer> digitSumToFreqMap = new HashMap<>();
        int count = 0;
        int maxGroupSize = 0;
        for (int i = 1; i <= n; i++) {
            int digitSum = getDigitSum(i);
            digitSumToFreqMap.put(digitSum, digitSumToFreqMap.getOrDefault(digitSum, 0) + 1);
            int groupSize = digitSumToFreqMap.getOrDefault(digitSum, 0);
            if (maxGroupSize == groupSize) {
                count++;
            } else if (maxGroupSize < groupSize) {
                count = 1;
                maxGroupSize = groupSize;
            }
        }
        return count;
    }
}