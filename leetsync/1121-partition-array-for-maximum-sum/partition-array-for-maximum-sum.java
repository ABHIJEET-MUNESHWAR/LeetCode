class Solution {

    int[] dp;

    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new int[501];
        Arrays.fill(dp, -1);
        return solveRecursionMemoization(arr, k, 0);
    }

    private int solveRecursionMemoization(int[] arr, int k, int index) {
        if (index >= arr.length) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int result = 0;
        for (int i = index; i < arr.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < arr.length && (j - i + 1) <= k; j++) {
                max = Math.max(max, arr[j]);
                result = Math.max(result, (j - i + 1) * max + solveRecursionMemoization(arr, k, j + 1));
            }
        }
        return dp[index] = result;
    }
}