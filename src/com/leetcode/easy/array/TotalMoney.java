package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    30/01/24,
 * Time:    9:08 am
 * https://leetcode.com/problems/calculate-money-in-leetcode-bank/
 */
public class TotalMoney {
  public static void main(String[] args) {
    TotalMoney totalMoney = new TotalMoney();
    System.out.println(totalMoney.totalMoney(20));
  }

  private int totalMoney(int n) {
    int total = 0;
    int count = 0;
    int inc = 1;
    for (int i = 1; i <= n; i++) {
      total += inc;
      if (i % 7 == 0) {
        count++;
        inc = count;
      }
      inc++;
    }
    return total;
  }
}