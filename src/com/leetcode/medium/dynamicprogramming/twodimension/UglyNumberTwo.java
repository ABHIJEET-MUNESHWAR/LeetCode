package com.leetcode.medium.dynamicprogramming.twodimension;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    19/06/24,
 * Time:    9:30 pm
 * 264. Ugly Number II
 * https://leetcode.com/problems/ugly-number-ii/description/
 */
public class UglyNumberTwo {
  public static void main(String[] args) {
    UglyNumberTwo uglyNumberTwo = new UglyNumberTwo();
    int n = 10;
    System.out.println(uglyNumberTwo.uglyNumberTwo(n));
  }

  private int uglyNumberTwo(int n) {
    int[] dp = new int[n + 1];
    // dp[i] is ith ugly number
    // dp[n] is nth ugly number
    // return dp[n]

    // First ugly number
    int i2 = 1, i3 = 1, i5 = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      int i2UglyNum = dp[i2] * 2;
      int i3UglyNum = dp[i3] * 3;
      int i5UglyNum = dp[i5] * 5;
      int minUglyNumber = Math.min(i2UglyNum, Math.min(i3UglyNum, i5UglyNum));
      dp[i] = minUglyNumber;
      // increment pointer
      if (minUglyNumber == i2UglyNum) {
        i2++;
      }
      if (minUglyNumber == i3UglyNum) {
        i3++;
      }
      if (minUglyNumber == i5UglyNum) {
        i5++;
      }
    }
    return dp[n];
  }
}