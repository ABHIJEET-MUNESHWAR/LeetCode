class Solution {
    public int maxProfit(int[] prices) {
        int size = prices.length;
        int[][] dp = new int[size][2];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return solve(prices, 0, prices.length, 1, dp);
    }

    private int solve(int[] prices, int dayIndex, int length, int isBuy, int[][] dp) {
        if (dayIndex >= length) {
            return 0;
        }
        if (dp[dayIndex][isBuy] != -1) {
            return dp[dayIndex][isBuy];
        }
        int profit = 0;
        if (isBuy == 1) {
            int take = solve(prices, dayIndex + 1, length, 0, dp) - prices[dayIndex];
            int notTake = solve(prices, dayIndex + 1, length, 1, dp);
            profit = Math.max(profit, Math.max(take, notTake));
        } else {
            int sell = prices[dayIndex] + solve(prices, dayIndex + 2, length, 1, dp);
            int notSell = solve(prices, dayIndex + 1, length, 0, dp);
            profit = Math.max(profit, Math.max(sell, notSell));
        }
        dp[dayIndex][isBuy] = profit;
        return profit;
    }
}