package com.leetcode.medium.dynamicprogramming;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    20/06/24,
 * Time:    10:50 am
 * 790. Domino and Tromino Tiling
 * https://leetcode.com/problems/domino-and-tromino-tiling/description/
 */
public class DominoTrominoTiling {
  public static void main(String[] args) {
    DominoTrominoTiling obj = new DominoTrominoTiling();
    int n = 4;
    System.out.println(obj.numTilingsRecursion(n));
    System.out.println(obj.numTilingsRecursionMemoization(n));
    System.out.println(obj.numTilingsBottomUp(n));
  }

  private int numTilingsBottomUp(int n) {
    if (n == 1 || n == 2) {
      return n;
    }
    if (n == 3) {
      return 5;
    }
    int[] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 5;
    for (int i = 4; i <= n; i++) {
      dp[i] = (2 * dp[i - 1] % mod + dp[i - 3] % mod) % mod;
    }
    return dp[n];
  }

  int[] dp;

  private int numTilingsRecursionMemoization(int n) {
    dp = new int[1001];
    Arrays.fill(dp, -1);
    return numTilingsRecursionAndMemoization(n);
  }

  private int numTilingsRecursionAndMemoization(int n) {
    if (n == 1 || n == 2) {
      return n;
    }
    if (n == 3) {
      return 5;
    }
    if (dp[n] != -1) {
      return dp[n];
    }
    return dp[n] = (2 * numTilingsRecursionAndMemoization(n - 1) % mod + numTilingsRecursionAndMemoization(n - 3) % mod) % mod;
  }

  int mod = 1000000007;

  private int numTilingsRecursion(int n) {
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }
    if (n == 3) {
      return 5;
    }
    return (2 * numTilingsRecursion(n - 1) % mod + numTilingsRecursion(n - 3) % mod) % mod;
  }
}