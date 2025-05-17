class Solution {
    public void sortColors(int[] nums) {
        int size = nums.length;
        int i = 0, j = 0, k = size - 1;
        while (j <= k) {
            if (nums[j] == 2) {
                swap(nums, j, k);
                k--;
            } else if (nums[j] == 0) {
                swap(nums, i, j);
                i++;
                j++;
            } else { // (nums[j] == 1)
                j++;
            }
        }
    }

    private void swap(int[] nums, int j, int k) {
        int temp = nums[j];
        nums[j] = nums[k];
        nums[k] = temp;
    }
}