package com.leetcode.easy.dynamicprogramming;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    13/08/22, Time:    6:43 PM 0, 1, 1, 2,
 * 3, 5, 8, 13, 21
 */
public class ClimbingStairs {

  public static void main(String[] args) {
    ClimbingStairs climbingStairs = new ClimbingStairs();
    System.out.println("Number of ways to climb stairs: " + climbingStairs.climbStairs(2));
    System.out.println("Number of ways to climb stairs: " + climbingStairs.climbStairsRecursion(2));
    System.out.println("Number of ways to climb stairs: " + climbingStairs.climbStairsRecursionMemoization(2));
    System.out.println("Number of ways to climb stairs: " + climbingStairs.climbStairsBottomUp(2));
  }

  private int climbStairsBottomUp(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  private int climbStairsRecursionMemoization(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    return solve(n, dp);
  }

  private int solve(int n, int[] dp) {
    if (n < 0) {
      return 0;
    }
    if (n == 0) {
      return 1;
    }
    if (dp[n] != -1) {
      return dp[n];
    }
    dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
    return dp[n];
  }

  private int climbStairsRecursion(int n) {
    if (n < 0) {
      return 0;
    }
    if (n == 0) {
      return 1;
    }
    return climbStairsRecursion(n - 1) + climbStairsRecursion(n - 2);
  }

  private Integer climbStairs(int n) {
    int a = 1, b = 2, c = 0;
    if (n < 3) {
      return n;
    }
    for (int i = 0; i < n; i++) {
      c = a + b;
      a = b;
      b = c;
    }
    return c;
  }
}