class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int maxOnce = 0;
        for (int num : nums) {
            maxOnce += num;
        }
        int left = 0, right = 0, currentOnce = 0, currentMaxOnce = 0;
        while (right < 2 * n) {
            if (nums[right % n] == 1) {
                currentOnce++;
            }
            int currentWindowSize = right - left + 1;
            if (currentWindowSize > maxOnce) {
                currentOnce -= nums[left % n];
                left++;
            }

            currentMaxOnce = Math.max(currentMaxOnce, currentOnce);
            right++;
        }
        return maxOnce - currentMaxOnce;
    }
}