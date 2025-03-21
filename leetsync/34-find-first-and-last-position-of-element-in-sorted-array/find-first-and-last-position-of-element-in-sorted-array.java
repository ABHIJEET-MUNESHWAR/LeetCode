class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstPosition = findFirstPosition(nums, target);
        int lastPosition = findLastPosition(nums, target);
        return new int[] { firstPosition, lastPosition };
    }

    private int findLastPosition(int[] nums, int target) {
        int size = nums.length;
        int left = 0;
        int right = size - 1;
        int lastPosition = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                lastPosition = mid;
                left = mid + 1;
            }
        }
        return lastPosition;
    }

    private int findFirstPosition(int[] nums, int target) {
        int size = nums.length;
        int left = 0;
        int right = size - 1;
        int firstPosition = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                firstPosition = mid;
                right = mid - 1;
            }
        }
        return firstPosition;
    }
}