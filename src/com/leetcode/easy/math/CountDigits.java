package com.leetcode.easy.math;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    16/02/23, Time:    9:56 pm
 * https://leetcode.com/problems/count-the-digits-that-divide-a-number/
 */
public class CountDigits {

  public static void main(String[] args) {
    CountDigits countDigits = new CountDigits();
    System.out.println(countDigits.countDigits(121));
  }

  private int countDigits(int num) {
    int n = num;
    int count = 0;
    while (n > 0) {
      int digit = n % 10;
      if (num % digit == 0) {
        count++;
      }
      n = n / 10;
    }
    return count;
  }
}