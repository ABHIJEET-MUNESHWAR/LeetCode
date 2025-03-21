package com.leetcode.easy.daily;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    24/08/22, Time:    10:26 AM
 * https://leetcode.com/problems/power-of-three/
 */
public class PowerOfThree {

  public static void main(String[] args) {
    PowerOfThree powerOfThree = new PowerOfThree();
    System.out.println(powerOfThree.isPowerOfThree(29));
  }

  private boolean isPowerOfThree(int n) {
    if (n < 1) {
      return false;
    }
    while (n % 3 == 0) {
      n = n / 3;
    }
    return n == 1;
  }

}