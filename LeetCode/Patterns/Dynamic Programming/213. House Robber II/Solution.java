class Solution {
    int[] dp = new int[101];

    public int rob(int[] nums) {
        int size = nums.length;
        if (size == 1) {
            return nums[0];
        }
        int[] dp = new int[size + 1];
        dp[0] = 0;

        for (int i = 1; i <= size - 1; i++) {
            int steal = nums[i - 1] + (((i - 2) >= 0) ? dp[i - 2] : 0);
            int skip = dp[i - 1];
            dp[i] = Math.max(steal, skip);
        }
        int result1 = dp[size - 1];
        dp[0] = 0;
        dp[1] = 0;
        dp = new int[size + 1];
        for (int i = 2; i <= size; i++) {
            int steal = nums[i - 1] + dp[i - 2];
            int skip = dp[i - 1];
            dp[i] = Math.max(steal, skip);
        }
        int result2 = dp[size];
        return Math.max(result1, result2);
    }

}