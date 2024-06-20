class Solution {
    int[][] dp;

    public int minFlipsMonoIncr(String s) {
        int size = s.length();
        dp = new int[size + 1][2];
        for (int i = 0; i < size; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solveRecursionMemoization(s.toCharArray(), 0, 0);
    }

    private int solveRecursionMemoization(char[] chars, int previous, int currentIndex) {
        int flipCount = Integer.MAX_VALUE;
        int nonFlipCount = Integer.MAX_VALUE;
        if (currentIndex >= chars.length) {
            return 0;
        }
        if (dp[currentIndex][previous] != -1) {
            return dp[currentIndex][previous];
        }
        if (chars[currentIndex] == '0') {
            if (previous == 1) {
                // 1, 0
                flipCount = 1 + solveRecursionMemoization(chars, 1, currentIndex + 1);
            } else {
                // 0, 0
                flipCount = 1 + solveRecursionMemoization(chars, 1, currentIndex + 1);
                nonFlipCount = solveRecursionMemoization(chars, 0, currentIndex + 1);
            }
        } else {
            // current char = 1
            if (previous == 1) {
                // 1, 1
                nonFlipCount = solveRecursionMemoization(chars, 1, currentIndex + 1);
            } else {
                // 0, 1
                flipCount = 1 + solveRecursionMemoization(chars, 0, currentIndex + 1);
                nonFlipCount = solveRecursionMemoization(chars, 1, currentIndex + 1);
            }
        }
        return dp[currentIndex][previous] = Math.min(flipCount, nonFlipCount);
    }
}