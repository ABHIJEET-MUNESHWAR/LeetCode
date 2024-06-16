package com.leetcode.easy.others;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    13/08/22, Time:    5:53 PM
 * 0, 1, 1, 2, 3, 5, 8, 13, 21
 */
public class Fibonacci {

  public static void main(String[] args) {
    Fibonacci fibonacci = new Fibonacci();
    System.out.println("Fibonacci number: " + fibonacci.fibonacci(5));
    System.out.println("Recursive Fibonacci number: " + fibonacci.recursiveFibonacci(5));
    System.out.println("Recursive Fibonacci number: " + fibonacci.recursiveMemoizeFibonacci(5));
    System.out.println("Recursive Fibonacci number: " + fibonacci.dynamicFibonacci(5));
  }

  private int dynamicFibonacci(int n) {
    int[] dp = new int[31];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= 30; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  private int recursiveMemoizeFibonacci(int n) {
    if (n <= 1) {
      return n;
    }
    int[] dp = new int[31];
    Arrays.fill(dp, -1);
    return solve(n, dp);
  }

  private int solve(int n, int[] dp) {
    if (n <= 1) {
      return n;
    }
    if (dp[n] != -1) {
      return dp[n];
    }
    dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
    return dp[n];
  }

  private Integer recursiveFibonacci(int n) {
    if (n <= 1) {
      return n;
    } else {
      return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

  }

  private Integer fibonacci(int n) {
    if (n <= 1) {
      return n;
    }
    int a = 0, b = 1, c = 0;
    for (int i = 0; i < n; i++) {
      c = a + b;
      a = b;
      b = c;
    }
    return c;
  }
}