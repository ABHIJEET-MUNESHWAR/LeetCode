class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int prefixZeros = 0;
        int windowSum = 0;
        int count = 0;

        int left = 0, right = 0;

        while (right < nums.length) {
            windowSum += nums[right];

            while (left < right && (nums[left] == 0 || windowSum > goal)) {
                if (nums[left] == 1) {
                    prefixZeros = 0;
                } else {
                    prefixZeros += 1;
                }

                windowSum -= nums[left];
                left++;
            }

            if (windowSum == goal) {
                count += 1 + prefixZeros;
            }
            right++;
        }

        return count;
    }
}