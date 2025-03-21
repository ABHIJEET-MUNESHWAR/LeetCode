package com.leetcode.easy.math;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    30/01/23, Time:    11:23 pm
 * https://leetcode.com/problems/n-th-tribonacci-number/
 */
public class Tribonacci {

  public static void main(String[] args) {
    Tribonacci tribonacci = new Tribonacci();
    System.out.println(tribonacci.tribonacci(4));
    System.out.println(tribonacci.tribonacciDP(4));
  }

  private int tribonacciDP(int n) {
    int[] dp = {0, 1, 1};
    for (int i = 3; i <= n; i++) {
      dp[i % 3] = dp[0] + dp[1] + dp[2];
    }
    return dp[n % 3];
  }

  private int tribonacci(int n) {
    if (n < 2) {
      return n;
    }
    int a = 0, b = 1, c = 1, d;
    while (n-- > 2) {
      d = a + b + c;
      a = b;
      b = c;
      c = d;
    }
    return c;
  }
}