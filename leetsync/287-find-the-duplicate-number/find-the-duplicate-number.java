class Solution {
    public int findDuplicate(int[] nums) {
        
    int size = nums.length;
    for (int num : nums) {
      int index = Math.abs(num);
      if (nums[index] < 0) {
        return index;
      }
      nums[index] = -nums[index];
    }
    return size;
    }
}