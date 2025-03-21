package com.leetcode.medium.dynamicprogramming.twodimension;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    21/06/24,
 * Time:    5:20 pm
 * 2466. Count Ways To Build Good Strings
 * https://leetcode.com/problems/count-ways-to-build-good-strings/description/
 */
public class CountWaysToBuildGoodStrings {
  public static void main(String[] args) {
    CountWaysToBuildGoodStrings countWaysToBuildGoodStrings = new CountWaysToBuildGoodStrings();
    int low = 3, high = 3, zero = 1, one = 1;
    System.out.println(countWaysToBuildGoodStrings.countGoodStringsRecursion(low, high, zero, one));
    System.out.println(countWaysToBuildGoodStrings.countGoodStringsRecursionMemoization(low, high, zero, one));
    System.out.println(countWaysToBuildGoodStrings.countGoodStringsBottomUp(low, high, zero, one));
  }

  private int countGoodStringsBottomUp(int low, int high, int zero, int one) {
    int[] dp = new int[high + 1];
    dp[0] = 1;
    int md = 1000000007;
    for (int i = Math.min(zero, one); i <= high; i++) {
      if (i >= zero) {
        dp[i] = (dp[i] + dp[i - zero]) % md;
      }
      if (i >= one) {
        dp[i] = (dp[i] + dp[i - one]) % md;
      }
    }
    int sum = 0;
    for (int i = low; i <= high; i++) {
      sum = (sum + dp[i]) % md;
    }
    return sum;
  }

  int[] dp;

  private int countGoodStringsRecursionMemoization(int low, int high, int zero, int one) {
    dp = new int[1000001];
    Arrays.fill(dp, -1);
    return solveRecursionMemoization(low, high, zero, one, 0);
  }

  private int solveRecursionMemoization(int low, int high, int zero, int one, int currentStringSize) {
    if (currentStringSize > high) {
      return 0;
    }
    if (dp[currentStringSize] != -1) {
      return dp[currentStringSize];
    }
    int addOne = 0;
    if (currentStringSize >= low && currentStringSize <= high) {
      addOne = 1;
    }
    int appendZero = solveRecursionMemoization(low, high, zero, one, currentStringSize + zero);
    int appendOne = solveRecursionMemoization(low, high, zero, one, currentStringSize + one);
    return dp[currentStringSize] = (addOne + appendZero + appendOne) % mod;
  }

  int mod = 1000000007;

  private int countGoodStringsRecursion(int low, int high, int zero, int one) {
    return solveRecursion(low, high, zero, one, 0);
  }

  private int solveRecursion(int low, int high, int zero, int one, int currentStringSize) {
    if (currentStringSize > high) {
      return 0;
    }
    int addOne = 0;
    if (currentStringSize >= low && currentStringSize <= high) {
      addOne = 1;
    }
    int appendZero = solveRecursion(low, high, zero, one, currentStringSize + zero);
    int appendOne = solveRecursion(low, high, zero, one, currentStringSize + one);
    return (addOne + appendZero + appendOne) % mod;
  }
}