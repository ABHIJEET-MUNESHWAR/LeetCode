class Solution {

    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        if (nums == null) {
            return 0;
        }
        int[][] dp = new int[nums.length][20001];

        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int diff = nums[i] - nums[j] + 10000;
                dp[i][diff] = Math.max(dp[i][diff], dp[j][diff] + 1); // DON'T forget to compare

                res = Math.max(res, dp[i][diff]);
            }
        }

        return res + 1;
    }
}