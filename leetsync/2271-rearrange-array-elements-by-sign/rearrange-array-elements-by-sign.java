class Solution {
    public int[] rearrangeArray(int[] nums) {
        int size = nums.length;
        int[] result = new int[size];
        int positiveIndexPosition = 0;
        int negativeIndexPosition = 1;
        for (int i = 0; i < size; i++) {
            if (nums[i] > 0) {
                result[positiveIndexPosition] = nums[i];
                positiveIndexPosition += 2;
            }
            if (nums[i] < 0) {
                result[negativeIndexPosition] = nums[i];
                negativeIndexPosition += 2;
            }
        }
        return result;
    }
}