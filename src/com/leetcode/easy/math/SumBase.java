package com.leetcode.easy.math;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    20/09/23,
 * Time:    10:11 am
 * https://leetcode.com/problems/sum-of-digits-in-base-k/description/
 */
public class SumBase {
  public static void main(String[] args) {
    SumBase sumBase = new SumBase();
    System.out.println(sumBase.sumBase(34, 6));
  }

  private int sumBase(int n, int k) {
    int sum = 0;
    while (n > 0) {
      sum += n % k;
      n = n / k;
    }
    return sum;
  }
}