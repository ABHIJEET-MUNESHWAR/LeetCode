class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int size = nums.length;
        int result = 0;
        int oddCount = 0;
        int previousCount = 0;
        int left = 0, right = 0;
        while (right < size) {
            if (nums[right] % 2 == 1) {
                oddCount++;
                previousCount = 0;
            }
            while (oddCount == k) {
                previousCount++;
                if (left < size && nums[left] % 2 == 1) {
                    oddCount--;
                }
                left++;
            }
            result += previousCount;
            right++;
        }
        return result;
    }
}