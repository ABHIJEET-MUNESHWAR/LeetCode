class Solution {
    public int majorityElement(int[] nums) {

      int len = nums.length;
      int count = 0;
      int num = 0;
      for (int i = 0; i < len; i++) {
        if (count == 0) {
          num = nums[i];
        }
        if (num != nums[i]) {
          count--;
        } else {
          count++;
        }
      }
      return num;
  }
}