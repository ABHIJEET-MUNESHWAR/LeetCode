class Solution {
    int[] dp;

    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int answer = coinCountDP(coins, amount);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private int coinCountDP(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[amount] != -1) {
            return dp[amount];
        }
        int minCoins = Integer.MAX_VALUE;
        int size = coins.length;
        for (int i = 0; i < size; i++) {
            int ans = coinCountDP(coins, amount - coins[i]);
            if (ans != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, 1 + ans);
            }
        }
        dp[amount] = minCoins;
        return minCoins;
    }
}