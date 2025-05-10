class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int zeroInOne = 0, zeroInTwo = 0;
        for (int num : nums1) {
            sum1 += num;
            if (num == 0) {
                sum1++;
                zeroInOne++;
            }
        }
        for (int num : nums2) {
            sum2 += num;
            if (num == 0) {
                sum2++;
                zeroInTwo++;
            }
        }
        if (sum1 < sum2 && zeroInOne == 0) {
            return -1;
        }
        if (sum1 > sum2 && zeroInTwo == 0) {
            return -1;
        }
        return Math.max(sum1, sum2);
    }
}