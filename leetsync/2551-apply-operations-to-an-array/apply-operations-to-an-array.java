class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if ((i + 1 < n) && nums[i] == nums[i + 1] && nums[i] != 0) {
                nums[i] = 2 * nums[i];
                nums[i + 1] = 0;
            }

            if (nums[i] != 0) {
                if (j != i) {
                    swap(nums, i, j);
                }
                j++;
            }
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}