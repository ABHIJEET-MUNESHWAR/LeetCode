class Solution {
    public int longestOnes(int[] nums, int k) {

        int size = nums.length;
        int left = 0;
        int right = 0;
        while (right < size) {
            if (nums[right] == 0) {
                k--;
            }
            if (k < 0) {
                if (nums[left] == 0) {
                    k++;
                }
                left++;
            }
            right++;
        }
        return right - left;
    }
}