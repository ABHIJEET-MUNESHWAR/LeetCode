package com.leetcode.easy.math;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    08/10/23,
 * Time:    11:25am
 */
public class DifferenceOfSums {
  public static void main(String[] args) {
    DifferenceOfSums differenceOfSums = new DifferenceOfSums();
    int n = 10, m = 3;
    System.out.println(differenceOfSums.differenceOfSums(n, m));
  }

  private int differenceOfSums(int n, int m) {
    int num1 = 0, num2 = 0;
    for (int i = 1; i <= n; i++) {
      if (i % m == 0) {
        num2 += i;
      } else {
        num1 += i;
      }
    }
    return num1 - num2;
  }
}