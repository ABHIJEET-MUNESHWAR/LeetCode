class Solution {
    int[][] dp;

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        dp = new int[nums1.length][nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solveRecursionMemoization(nums1, nums2, 0, 0);
    }

    private int solveRecursionMemoization(int[] nums1, int[] nums2, int i, int j) {
        if (i == nums1.length || j == nums2.length) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (nums1[i] == nums2[j]) {
            return dp[i][j] = 1 + solveRecursionMemoization(nums1, nums2, i + 1, j + 1);
        } else {
            return dp[i][j] = Math.max(solveRecursionMemoization(nums1, nums2, i + 1, j),
                    solveRecursionMemoization(nums1, nums2, i, j + 1));
        }
    }
}