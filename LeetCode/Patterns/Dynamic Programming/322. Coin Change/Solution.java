class Solution {
    public int coinChange(int[] coins, int amount) {
        int answer = coinCount(coins, amount);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private int coinCount(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        int minCoins = Integer.MAX_VALUE;
        int size = coins.length;
        for (int i = 0; i < size; i++) {
            int ans = coinCount(coins, amount - coins[i]);
            if (ans != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, 1 + ans);
            }
        }
        return minCoins;
    }
}