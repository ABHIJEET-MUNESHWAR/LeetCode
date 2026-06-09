class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;

        for (int x : nums) {
            maxi = Math.max(maxi, x);
            mini = Math.min(mini, x);
        }

        return 1L * k * (maxi - mini);
    }
}