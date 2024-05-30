package com.leetcode.medium.dynamicprogramming;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    30/05/24,
 * Time:    6:06 pm
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 */
public class BuySellCoolDownProfit {
  public static void main(String[] args) {
    BuySellCoolDownProfit buySellCoolDownProfit = new BuySellCoolDownProfit();
    int[] prices = {1, 2, 3, 0, 2};
    System.out.println(buySellCoolDownProfit.maxProfit(prices));
    System.out.println(buySellCoolDownProfit.maxProfitBottomUp(prices));
  }

  private int maxProfitBottomUp(int[] prices) {
    int size = prices.length;
    if (size == 0 || size == 1) {
      return 0;
    }
    int[] dp = new int[size + 1];
    dp[0] = 0;
    dp[1] = Math.max(prices[1] - prices[0], 0);
    for (int i = 2; i < size; i++) {
      dp[i] = dp[i - 1];
      // Fill up dp[i]
      for (int j = 0; j < i; j++) {
        int todayProfit = prices[i] - prices[j];
        int prevProfit = (j >= 2) ? dp[j - 2] : 0;
        dp[i] = Math.max(prevProfit + todayProfit, dp[i]);
      }
    }
    return dp[size - 1];
  }

  private int maxProfit(int[] prices) {
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