class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int size = nums.length;
        int[] result = new int[size];
        int left = 0;
        int right = size - 1;
        for (int i = 0; i < size; i++) {
            if (nums[i] < pivot) {
                result[left++] = nums[i];
            }
            if (nums[size - 1 - i] > pivot) {
                result[right--] = nums[size - 1 - i];
            }
        }
        while (left <= right) {
            result[left++] = pivot;
            result[right--] = pivot;
        }
        return result;
    }
}