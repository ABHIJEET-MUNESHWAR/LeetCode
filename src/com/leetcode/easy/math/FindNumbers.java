package com.leetcode.easy.math;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    23/09/23,
 * Time:    11:29 pm
 * https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 */
public class FindNumbers {
  public static void main(String[] args) {
    FindNumbers findNumbers = new FindNumbers();
    int[] nums = {12, 345, 2, 6, 7896};
    System.out.println(findNumbers.findNumbers(nums));
    System.out.println(findNumbers.findNumbers2(nums));
  }

  private int findNumbers2(int[] nums) {
    int count = 0;
    for (int n : nums) {
      if ((n > 9 && n < 100) || (n > 999 && n < 10000) || (n == 100000)) {
        count++;
      }
    }
    return count;
  }

  private int findNumbers(int[] nums) {
    int count = 0;
    for (int n : nums) {
      if (countDigits(n) % 2 == 0) {
        count++;
      }
    }
    return count;
  }

  private int countDigits(int n) {
    int digits = 0;
    while (n > 0) {
      n = n / 10;
      digits++;
    }
    return digits;
  }
}