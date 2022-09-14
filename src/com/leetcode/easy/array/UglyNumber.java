package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    10/09/22, Time:    6:13 PM
 * https://leetcode.com/problems/ugly-number/
 */
public class UglyNumber {

  public static void main(String[] args) {
    UglyNumber uglyNumber = new UglyNumber();
    System.out.println(uglyNumber.isUgly(14));
  }

  private boolean isUgly(int n) {
    if (n == 0) {
      return false;
    }
    while (n % 2 == 0) {
      n = n / 2;
    }
    while (n % 3 == 0) {
      n = n / 3;
    }
    while (n % 5 == 0) {
      n = n / 5;
    }
    return n == 1;
  }
}