class Solution {
    public int findFinalValue(int[] nums, int original) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == original) {
                original *= 2;
                i = -1;
            }
        }
        return original;
    }
}