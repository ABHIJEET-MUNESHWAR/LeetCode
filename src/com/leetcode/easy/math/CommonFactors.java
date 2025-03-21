package com.leetcode.easy.math;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    03/09/23,
 * Time:    10:31 am
 * https://leetcode.com/problems/number-of-common-factors/
 */
public class CommonFactors {
  public static void main(String[] args) {
    CommonFactors commonFactors = new CommonFactors();
    System.out.println(commonFactors.commonFactors(25, 30));
  }

  private int commonFactors(int a, int b) {
    int count = 0;
    if (a < b) {
      for (int i = 1; i <= a; i++) {
        if ((a % i == 0) && (b % i == 0)) {
          count++;
        }
      }
    } else {
      for (int i = 1; i <= b; i++) {
        if ((a % i == 0) && (b % i == 0)) {
          count++;
        }
      }
    }
    return count;
  }
}