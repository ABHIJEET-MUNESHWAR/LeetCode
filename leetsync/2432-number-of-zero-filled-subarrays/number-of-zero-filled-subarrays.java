class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        long result = 0;
        int l = 0, i = 0;
        while (i < n) {
            long zeros = 0;
            if (nums[i] == 0) {
                while (i < n && nums[i] == 0) {
                    i++;
                    zeros++;
                }
            } else {
                i++;
            }
            result += (zeros) * (zeros + 1) / 2;
        }
        return result;
    }
}