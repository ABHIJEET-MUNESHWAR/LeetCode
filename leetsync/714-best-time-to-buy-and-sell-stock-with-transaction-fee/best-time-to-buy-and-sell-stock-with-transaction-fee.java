class Solution {

    int[][] dp;

    public int maxProfit(int[] prices, int fee) {
        dp = new int[50001][2];
        for (int i = 0; i < 50001; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solveRecursionMemoization(prices, fee, 0, 1);
    }

    private int solveRecursionMemoization(int[] prices, int fee, int day, int isBuy) {
        if (day >= prices.length) {
            return 0;
        }
        if (dp[day][isBuy] != -1) {
            return dp[day][isBuy];
        }
        int profit = 0;
        if (isBuy == 1) {
            int buy = solveRecursionMemoization(prices, fee, day + 1, 0) - prices[day];
            int notBuy = solveRecursionMemoization(prices, fee, day + 1, 1);
            profit = Math.max(profit, Math.max(buy, notBuy));
        } else {
            int sell = solveRecursionMemoization(prices, fee, day + 1, 1) + prices[day] - fee;
            int notSell = solveRecursionMemoization(prices, fee, day + 1, 0);
            profit = Math.max(profit, Math.max(sell, notSell));
        }
        return dp[day][isBuy] = profit;
    }
}