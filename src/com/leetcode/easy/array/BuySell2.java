package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    07/04/22, Time:    9:07 AM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/564/
 * Best Time
 * to Buy and Sell Stock II
 */
public class BuySell2 {

  public static void main(String[] args) {
    int[] prices = new int[]{7, 1, 5, 3, 6, 4};
    //int[] prices = new int[]{1, 2, 3, 4, 5};
    //int[] prices = new int[]{7, 6, 4, 3, 1};
    BuySell2 buySell = new BuySell2();
    int maxProfit = buySell.getMaxProfit(prices);
    System.out.println("Max Profit = " + maxProfit);
  }

  private int getMaxProfit(int[] prices) {
    int n = prices.length;
    int maxProfit = 0;
    if (n == 0) {
      return 0;
    } else {
      for (int i = 1; i < n; i++) {
        if (prices[i - 1] < prices[i]) {
          maxProfit += Math.max(0, prices[i] - prices[i - 1]);
        }
      }
    }
    return maxProfit;
  }

}