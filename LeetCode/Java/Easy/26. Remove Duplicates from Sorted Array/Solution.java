class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int updatedIndex = 0;
        int i=0;
        for (i = 1; i < n; i++) {
          if (nums[i] != nums[i - 1]) {
            nums[updatedIndex++] = nums[i-1];
          }
        }
        nums[updatedIndex++] = nums[i-1];
        return updatedIndex;
    }
}