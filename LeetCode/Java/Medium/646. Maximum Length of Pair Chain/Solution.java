class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int size = pairs.length;
        int[] dp = new int[1001];
        for (int i = 0; i < 1001; i++) {
            Arrays.fill(dp, 1);
        }
        int maxLength = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLength = Math.max(maxLength, dp[i]);
                }
            }
        }
        return maxLength;
    }
}