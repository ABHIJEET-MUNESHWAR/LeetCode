package com.leetcode.medium.dynamicprogramming.twodimension;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    22/06/24,
 * Time:    7:17 pm
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {
  public static void main(String[] args) {
    BestTimeToBuyAndSellStockWithTransactionFee obj = new BestTimeToBuyAndSellStockWithTransactionFee();
    int[] prices = {1, 3, 2, 8, 4, 9};
    int fee = 2;
    System.out.println(obj.maxProfitRecursion(prices, fee));
    System.out.println(obj.maxProfitRecursionMemoization(prices, fee));
  }

  int[][] dp;

  private int maxProfitRecursionMemoization(int[] prices, int fee) {
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

  private int maxProfitRecursion(int[] prices, int fee) {
    return solveRecursion(prices, fee, 0, true);
  }

  private int solveRecursion(int[] prices, int fee, int day, boolean isBuy) {
    if (day >= prices.length) {
      return 0;
    }
    int profit = 0;
    if (isBuy) {
      int buy = solveRecursion(prices, fee, day + 1, false) - prices[day];
      int notBuy = solveRecursion(prices, fee, day + 1, true);
      profit = Math.max(profit, Math.max(buy, notBuy));
    } else {
      int sell = solveRecursion(prices, fee, day + 1, true) + prices[day] - fee;
      int notSell = solveRecursion(prices, fee, day + 1, false);
      profit = Math.max(profit, Math.max(sell, notSell));
    }
    return profit;
  }
}