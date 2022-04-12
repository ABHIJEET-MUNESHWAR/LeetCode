package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    12/04/22, Time:    8:41 AM
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BuySell1 {

  public static void main(String[] args) {
    BuySell1 buySell = new BuySell1();
    int[] prices = new int[]{7, 1, 5, 3, 6, 4};
    //int[] prices = new int[]{1, 2, 3, 4, 5};
    //int[] prices = new int[]{7, 6, 4, 3, 1};
    int maxProfit = buySell.getMaxProfit(prices);
    System.out.println("Max Profit = " + maxProfit);
  }

  private int getMaxProfit(int[] prices) {
    int n = prices.length;
    int min = Integer.MAX_VALUE; //
    int maxProfit = Integer.MIN_VALUE;
    int pist = 0; // Profit if sold today
    if (n == 0) {
      return 0;
    } else {
      for (int i = 0; i < n; i++) {
        if (min > prices[i]) {
          min = prices[i];
        }
        pist = prices[i] - min;
        if (maxProfit < pist) {
          maxProfit = pist;
        }
      }
    }
    return maxProfit;
  }
}