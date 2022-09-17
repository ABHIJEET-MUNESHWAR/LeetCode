package com.leetcode.easy.math;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    17/09/22, Time:    11:19 PM
 * https://leetcode.com/problems/arranging-coins/
 */
public class ArrangingCoins {

  public static void main(String[] args) {
    ArrangingCoins arrangingCoins = new ArrangingCoins();
    System.out.println(arrangingCoins.arrangeCoins(8));
  }

  private int arrangeCoins(int n) {
    int count = 0;
    int totalCoins = n;
    for (int i = 1; i < totalCoins; i++) {
      n -= i;
      if (i > n) {
        return i - 1;
      }
    }
    return count;
  }
}