class Solution {
    public int maxProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (max1 <= num) {
                max2 = max1;
                max1 = num;
            } else if (max2 <= num) {
                max2 = num;
            }
        }
        return (max1 - 1) * (max2 - 1);
    }
}