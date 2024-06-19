class Solution {
    public int findLongestChain(int[][] pairs) {
        dp = new int[1001][1001];
        for (int i = 0; i < 1001; i++) {
            Arrays.fill(dp[i], -1);
        }
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        return solveRecursionMemoization(pairs, -1, 0);
    }

    private int solveRecursionMemoization(int[][] pairs, int previousIndex, int currentIndex) {
        if (currentIndex >= pairs.length) {
            return 0;
        }
        if (previousIndex != -1 && dp[previousIndex][currentIndex] != -1) {
            return dp[previousIndex][currentIndex];
        }
        int take = 0;
        if (previousIndex == -1 || pairs[previousIndex][1] < pairs[currentIndex][0]) {
            take = 1 + solveRecursionMemoization(pairs, currentIndex, currentIndex + 1);
        }
        int skip = solveRecursionMemoization(pairs, previousIndex, currentIndex + 1);
        if (previousIndex != -1) {
            dp[previousIndex][currentIndex] = Math.max(take, skip);
        }
        return Math.max(take, skip);
    }

    int dp[][];
}