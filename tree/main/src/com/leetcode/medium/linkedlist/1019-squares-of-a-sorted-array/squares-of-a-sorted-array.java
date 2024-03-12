class Solution {
    public int[] sortedSquares(int[] nums) {

    int size = nums.length;
    int[] result = new int[size];
    int i = 0, j = size - 1;
    for (int k = size - 1; k >= 0; k--) {
      if (Math.abs(nums[i]) < Math.abs(nums[j])) {
        result[k] = nums[j] * nums[j];
        j--;
      } else {
        result[k] = nums[i] * nums[i];
        i++;
      }
    }
    return result;        
    }
}