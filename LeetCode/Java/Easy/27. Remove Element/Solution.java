class Solution {
    public int removeElement(int[] nums, int val) {
        int m = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
          if (nums[i] != val) {
            nums[m++] = nums[i];
          }
        }
        return m;    
    }
}