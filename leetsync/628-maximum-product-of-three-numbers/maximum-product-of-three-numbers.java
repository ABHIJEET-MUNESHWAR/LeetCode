class Solution {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int x : nums) {

            // Update three largest numbers
            if (x >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = x;
            } else if (x >= max2) {
                max3 = max2;
                max2 = x;
            } else if (x >= max3) {
                max3 = x;
            }

            // Update two smallest numbers
            if (x <= min1) {
                min2 = min1;
                min1 = x;
            } else if (x <= min2) {
                min2 = x;
            }
        }

        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}