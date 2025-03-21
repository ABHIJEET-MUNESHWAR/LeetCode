class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxFrequency = 0;
        int[] prefixSumArray = new int[n];
        int prefixSum = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            prefixSumArray[i] = prefixSum;
        }
        for (int i = 0; i < n; i++) {
            maxFrequency = Math.max(maxFrequency, binarySearch(nums, k, i, prefixSumArray));
        }
        return maxFrequency;
    }

    private int binarySearch(int[] nums, int k, int targetIndex, int[] prefixSumArray) {
        int left = 0;
        int right = targetIndex;
        int result = targetIndex;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long count = targetIndex - mid + 1;
            long windowSum = count * nums[targetIndex];
            long currentSum = prefixSumArray[targetIndex] - prefixSumArray[mid] + nums[mid];
            int difference = (int) (windowSum - currentSum);
            if (difference > k) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }
        return targetIndex - result + 1;
    }
}