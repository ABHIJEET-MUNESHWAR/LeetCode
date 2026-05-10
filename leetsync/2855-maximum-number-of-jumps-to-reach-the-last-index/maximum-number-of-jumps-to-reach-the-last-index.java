class Solution {
    public int maximumJumps(int[] nums, int target) {

        int n = nums.length;

        // dp[i] stores maximum jumps to reach index i
        int[] dp = new int[n];

        // Mark all indices unreachable
        Arrays.fill(dp, -1);

        // Starting index needs 0 jumps
        dp[0] = 0;

        for (int i = 1; i < n; i++) {

            // Check all previous indices
            for (int j = 0; j < i; j++) {

                // Valid jump and previous index reachable
                if (Math.abs(nums[i] - nums[j]) <= target && dp[j] != -1) {

                    // Update maximum jumps
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n - 1];
    }
}