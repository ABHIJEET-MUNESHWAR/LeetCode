class Solution {
    public int findMinNum(int[] nums, int n) {
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        // First find min
        // Then do binary search into each part
        int n = nums.length;
        int minIndex = findMinNum(nums, n);
        int targetIndex = binarySearch(nums, 0, minIndex - 1, target);
        if (targetIndex == -1) {
            targetIndex = binarySearch(nums, minIndex, n - 1, target);
        }
        return targetIndex;
    }
}