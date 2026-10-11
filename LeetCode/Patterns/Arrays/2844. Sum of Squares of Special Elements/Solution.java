class Solution {
    public int sumOfSquares(int[] nums) {
    int sum = 0;
    int size = nums.length;
    for (int i = 0; i < size; i++) {
      int index = i + 1;
      if (size % (index) == 0) {
        sum += (nums[i] * nums[i]);
      }
    }
    return sum;
    }
}