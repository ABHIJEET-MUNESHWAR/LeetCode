class Solution {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        int[][] dp = new int[size1 + 1][size2 + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= size1; i++) {
            for (int j = 1; j <= size2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[size1][size2];
    }
}