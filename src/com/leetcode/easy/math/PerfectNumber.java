package com.leetcode.easy.math;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    24/11/22, Time:    10:40 PM
 * https://leetcode.com/problems/perfect-number/
 */
public class PerfectNumber {

  public static void main(String[] args) {
    PerfectNumber perfectNumber = new PerfectNumber();
    System.out.println(perfectNumber.checkPerfectNumber(28));
  }

  private boolean checkPerfectNumber(int num) {
    if (num == 1) {
      return false;
    }
    int sum = 1;
    int sqrt = (int) Math.sqrt(num);
    for (int i = 2; i <= sqrt; i++) {
      if (num % i == 0) {
        sum += i + num / i;
      }
    }
    return num == sum;
  }
}