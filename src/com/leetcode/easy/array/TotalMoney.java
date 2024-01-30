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
    System.out.println(totalMoney.totalMoney(10));
  }

  private int totalMoney(int n) {
    int total = 0;
    int div = n / 7;
    int rem = n % 7;
    int start = 1;
    for (int i = 0; i < div; i++) {
      int end = start + 6;
      int temp = ((start + end) * 7) / 2;
      total += temp;
      start++;
    }
    for (int i = 0; i < rem; i++) {
      total += start++;
    }
    return total;
  }
}