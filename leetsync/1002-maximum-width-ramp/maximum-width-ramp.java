class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;

        // Create an array to store the maximum values from the right
        int[] maxRight = new int[n];
        maxRight[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], nums[i]);
        }
        int i = 0;
        int j = 0;
        int ramp = 0;
        // Find the maximum width ramp
        while (j < n) {
            while (i < j && nums[i] > maxRight[j]) {
                i++;
            }
            ramp = Math.max(ramp, j - i);
            j++;
        }
        return ramp;
    }
}