class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int currAsc = 1;
        int currDesc = 1;
        int maxLength = 1;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                currAsc++;
                currDesc = 1;
            } else if (nums[i] > nums[i + 1]) {
                currDesc++;
                currAsc = 1;
            } else {
                currAsc = 1;
                currDesc = 1;
            }
            maxLength = Math.max(maxLength, Math.max(currAsc, currDesc));
        }
        return maxLength;
    }
}