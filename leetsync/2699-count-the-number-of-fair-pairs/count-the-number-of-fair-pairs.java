class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        Arrays.sort(nums);
        long result = 0;
        for (int i = 0; i < n; i++) {
            int leftIndex = lowerBound(nums, i + 1, n, lower - nums[i]); // Find the first element not less than (lower
                                                                         // -
            // nums[i])
            int rightIndex = upperBound(nums, i + 1, n, upper - nums[i]); // Find the first element greater than (upper
                                                                          // -
            // nums[i])
            int x = leftIndex - i - 1;
            int y = rightIndex - i - 1;
            result += (y - x);
        }
        return result;
    }

    public int lowerBound(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public int upperBound(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}