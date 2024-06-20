class Solution {
    public boolean canJump(int[] nums) {
        int size = nums.length;
        boolean[] dp = new boolean[size];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 1; i < size; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && nums[j] + j >= i) {
                    dp[i] = true;
                }
            }
        }
        return dp[size - 1];
    }
}