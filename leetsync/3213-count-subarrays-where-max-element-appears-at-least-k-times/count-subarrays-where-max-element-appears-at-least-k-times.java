class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        long result = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (max < num) {
                max = num;
            }
        }
        int left = 0, right = 0, maxFreq = 0;
        while (right < n) {
            if (nums[right] == max) {
                maxFreq++;
            }
            while (maxFreq >= k) {
                result += n - right;
                if (nums[left] == max) {
                    maxFreq--;
                }
                left++;
            }
            right++;
        }
        return result;
    }
}