class Solution {
    public int countSubSets(int index, int currentOr, int maxOr, int[] nums, int[][] dp) {
        if (index == nums.length) {
            if (currentOr == maxOr) {
                return dp[index][currentOr] = 1; // Found one subset
            }
            return dp[index][currentOr] = 0;
        }

        if (dp[index][currentOr] != -1) {
            return dp[index][currentOr];
        }

        // Take nums[idx]
        int takeCount = countSubSets(index + 1, currentOr | nums[index], maxOr, nums, dp);

        // Not taken nums[idx]
        int skipCount = countSubSets(index + 1, currentOr, maxOr, nums, dp);

        return dp[index][currentOr] = (takeCount + skipCount);
    }

    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for (int num : nums) {
            maxOr |= num;
        }
        int currentOr = 0;
        int n = nums.length;
        int[][] dp = new int[n + 1][maxOr + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= maxOr; j++) {
                dp[i][j] = -1;
            }
        }
        return countSubSets(0, currentOr, maxOr, nums, dp);
    }
}