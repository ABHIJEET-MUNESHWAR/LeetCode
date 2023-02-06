package com.leetcode.easy.math;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    06/02/23, Time:    10:33 am
 * https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 */
public class SubtractProductAndSum {

  public static void main(String[] args) {
    SubtractProductAndSum subtractProductAndSum = new SubtractProductAndSum();
    System.out.println(subtractProductAndSum.subtractProductAndSum(234));
  }

  private int subtractProductAndSum(int n) {
    int product = 1;
    int sum = 0;
    while (n > 0) {
      int num = n % 10;
      n = n / 10;
      product *= num;
      sum += num;
    }
    return product - sum;
  }
}