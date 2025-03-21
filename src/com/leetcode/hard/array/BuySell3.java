package com.leetcode.hard.array;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    07/04/22, Time:    9:07 AM
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/ Best Time to Buy and Sell
 * Stock III
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/39611/Is-it-Best-Solution-with-O(n)-O(1)./242914
 */
public class BuySell3 {

  public static void main(String[] args) {
    int[] prices = new int[]{7, 1, 5, 3, 6, 4};
    //int[] prices = new int[]{1, 2, 3, 4, 5};
    //int[] prices = new int[]{7, 6, 4, 3, 1};
    BuySell3 buySell = new BuySell3();
    int maxProfit = buySell.getMaxProfit(prices);
    System.out.println("Max Profit = " + maxProfit);
  }

  private int getMaxProfit(int[] prices) {
    int buy1 = Integer.MAX_VALUE, buy1sell1 = 0, buy2 = Integer.MAX_VALUE, buy2sell2 = 0;
    for (int price : prices) {
      buy1 = Math.min(buy1, price);
      buy1sell1 = Math.max(buy1sell1, price - buy1);
      buy2 = Math.min(buy2, price - buy1sell1);
      buy2sell2 = Math.max(buy2sell2, price - buy2);
    }
    return buy2sell2;
  }

}