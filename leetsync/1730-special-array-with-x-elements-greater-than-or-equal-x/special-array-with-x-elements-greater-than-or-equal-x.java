class Solution {
    public int specialArray(int[] nums) {
        int size = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i <= size; i++) {
            int totalGreaterElements = 0;
            for (int j = 0; j < size; j++) {
                if (nums[j] >= i) {
                    totalGreaterElements++;
                }
            }
            if (totalGreaterElements == i) {
                return i;
            }
        }
        return -1;
    }
}