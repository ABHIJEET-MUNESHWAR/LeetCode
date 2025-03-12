class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int positives = 0, negatives = 0;
        for (int num : nums) {
            if (num > 0) {
                positives++;
            } else if (num < 0) {
                negatives++;
            }
        }
        return Math.max(positives, negatives);
    }
}