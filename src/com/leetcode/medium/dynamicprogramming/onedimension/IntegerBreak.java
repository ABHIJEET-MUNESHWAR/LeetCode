package com.leetcode.medium.dynamicprogramming.onedimension;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    25/06/24,
 * Time:    9:09 pm
 * 343. Integer Break
 * https://leetcode.com/problems/integer-break/description/
 */
public class IntegerBreak {
  public static void main(String[] args) {
    IntegerBreak integerBreak = new IntegerBreak();
    int n = 10;
    System.out.println(integerBreak.integerBreakRecursion(n));
    System.out.println(integerBreak.integerBreakRecursionMemoization(n));
  }

  int[] dp;

  private int integerBreakRecursionMemoization(int n) {
    dp = new int[n + 1];
    Arrays.fill(dp, -1);
    return solveRecursionMemoization(n);
  }

  private int solveRecursionMemoization(int n) {
    if (n == 1) {
      return 1;
    }
    if (dp[n] != -1) {
      return dp[n];
    }
    int result = Integer.MIN_VALUE;
    for (int i = 1; i <= n - 1; i++) {
      int product = i * Math.max(n - i, solveRecursionMemoization(n - i));
      result = Math.max(result, product);
    }
    return dp[n] = result;
  }

  private int integerBreakRecursion(int n) {
    return solveRecursion(n);
  }

  private int solveRecursion(int n) {
    if (n == 1) {
      return 1;
    }
    int result = Integer.MIN_VALUE;
    for (int i = 1; i <= n - 1; i++) {
      int product = i * Math.max(n - i, solveRecursion(n - i));
      result = Math.max(result, product);
    }
    return result;
  }
}