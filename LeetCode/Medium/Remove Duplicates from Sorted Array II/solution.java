class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 2;
        int n = nums.length;
        for (int i = 2; i < n; i++) {
            if (nums[j - 2] != nums[i]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}