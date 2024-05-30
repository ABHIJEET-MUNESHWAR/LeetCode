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