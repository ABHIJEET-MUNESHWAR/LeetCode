class Solution {
    public int specialArray(int[] nums) {
        int size = nums.length;
        Arrays.sort(nums);
        for (int x = 0; x <= size; x++) {
            int index = lowerBoundBinarySearch(nums, x);
            if ((size - index) == x) {
                return x;
            }
        }
        return -1;
    }

    private int lowerBoundBinarySearch(int[] nums, int x) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}