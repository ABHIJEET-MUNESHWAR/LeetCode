class Solution {
    public int specialArray(int[] nums) {
        int size = nums.length;
        for (int x = 0; x <= size; x++) {
            int totalGreaterElements = getTotalGreaterElements(nums, x);
            if (totalGreaterElements == x) {
                return x;
            }
        }
        return -1;
    }

    private static int getTotalGreaterElements(int[] nums, int x) {
        int size = nums.length;
        int totalGreaterElements = 0;
        for (int j = 0; j < size; j++) {
            if (nums[j] >= x) {
                totalGreaterElements++;
            }
        }
        return totalGreaterElements;
    }
}