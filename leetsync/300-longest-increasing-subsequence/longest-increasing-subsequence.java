class Solution {

    public int lengthOfLIS(int[] nums) {
        int[] t = new int[2501];
        for (int i = 0; i < 2501; i++) {
            t[i] = 1;
        }
        int size = nums.length;
        int maxLIS = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    t[i] = Math.max(t[i], t[j] + 1);
                    maxLIS = Math.max(maxLIS, t[i]);
                }
            }
        }
        return maxLIS;
    }
}