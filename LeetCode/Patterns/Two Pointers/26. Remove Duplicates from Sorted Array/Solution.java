class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int j = 0;
        int i = 0;
        for (i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j++] = nums[i - 1];
            }
        }
        nums[j++] = nums[i - 1];
        return j;
    }
}