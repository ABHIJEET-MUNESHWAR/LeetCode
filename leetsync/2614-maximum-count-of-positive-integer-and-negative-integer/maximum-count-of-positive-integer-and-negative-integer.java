class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int positives = lowerBound(nums, 1); // >=1
        int negatives = lowerBound(nums, 0); // >=0
        return Math.max(n - positives, negatives);
    }

    public int lowerBound(int[] nums, int target) {
        int n = nums.length;
        int result = n;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }
        return result;
    }
}