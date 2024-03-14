class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        int count = 0;
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            int prefixSum = 0;
            for (int j = i; j < size; j++) {
                prefixSum += nums[j];
                if (prefixSum == goal) {
                    count++;
                }
            }
        }
        return count;
    }
}