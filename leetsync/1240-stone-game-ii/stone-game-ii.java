class Solution {

    int[][][] dp;

    public int stoneGameII(int[] piles) {
        dp = new int[2][101][101];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 101; j++) {
                for (int k = 0; k < 101; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return solveForAliceRecursionMemoization(piles, 1, 0, 1);
    }

    private int solveForAliceRecursionMemoization(int[] piles, int person, int index, int m) {
        if (index >= piles.length) {
            return 0;
        }
        if (dp[person][index][m] != -1) {
            return dp[person][index][m];
        }
        int result = person == 1 ? -1 : Integer.MAX_VALUE;
        int stones = 0;
        for (int x = 1; x <= Math.min(2 * m, piles.length - index); x++) {
            stones += piles[index + x - 1];
            if (person == 1) {
                // Alice
                result = Math.max(result,
                        stones + solveForAliceRecursionMemoization(piles, 0, index + x, Math.max(x, m)));
            } else {
                // Bob
                result = Math.min(result, solveForAliceRecursionMemoization(piles, 1, index + x, Math.max(x, m)));
            }
        }
        return dp[person][index][m] = result;
    }

}