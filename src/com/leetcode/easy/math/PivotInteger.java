package com.leetcode.easy.math;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    19/07/23,
 * Time:    11:51 pm
 */
public class PivotInteger {
  public static void main(String[] args) {
    PivotInteger pivotInteger = new PivotInteger();
    System.out.println(pivotInteger.pivotInteger(8));
    System.out.println(pivotInteger.pivotInteger2(8));
  }

  private int pivotInteger(int n) {
    int prefixSum = 0;
    int totalSum = 0;
    for (int i = 1; i <= n; i++) {
      totalSum += i;
    }
    for (int i = 1; i <= n; i++) {
      prefixSum += i;
      if ((totalSum - prefixSum + i) == prefixSum) {
        return i;
      }
    }
    return -1;
  }

  private int pivotInteger2(int n) {
    int sum = n * (n + 1) / 2;
    int sqrt = (int) Math.sqrt(sum);
    return sqrt * sqrt == sum ? sqrt : -1;
  }
}