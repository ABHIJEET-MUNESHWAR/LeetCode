class Solution {
    public int specialArray(int[] nums) {
        int size = nums.length;
        Arrays.sort(nums);
        int xLeft = 0;
        int xRight = size;
        while (xLeft <= xRight) {
            int xMid = (xLeft + xRight) / 2;
            int index = lowerBoundBinarySearch(nums, xMid);
            if (size - index == xMid) {
                return xMid;
            } else if (size - index > xMid) {
                xLeft = xMid + 1;
            } else {
                xRight = xMid - 1;
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