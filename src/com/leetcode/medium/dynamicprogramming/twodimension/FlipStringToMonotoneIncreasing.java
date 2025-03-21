package com.leetcode.medium.dynamicprogramming.twodimension;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    20/06/24,
 * Time:    6:37 pm
 * 926. Flip String to Monotone Increasing
 * https://leetcode.com/problems/flip-string-to-monotone-increasing/description/
 */
public class FlipStringToMonotoneIncreasing {
  public static void main(String[] args) {
    FlipStringToMonotoneIncreasing flipStringToMonotoneIncreasing = new FlipStringToMonotoneIncreasing();
    String s = "010110";
    System.out.println(flipStringToMonotoneIncreasing.minFlipsMonoIncrRecursion(s));
    System.out.println(flipStringToMonotoneIncreasing.minFlipsMonoIncrRecursionMemoization(s));
    System.out.println(flipStringToMonotoneIncreasing.minFlipsMonoOptimised(s));
  }

  private int minFlipsMonoOptimised(String s) {
    char[] chars = s.toCharArray();
    int size = s.length();
    int countOfOnce = 0;
    int flips = 0;
    for (char ch : chars) {
      if (ch == '1') {
        countOfOnce++;
      } else {
        flips = Math.min(flips + 1, countOfOnce);
      }
    }
    return flips;
  }

  int[][] dp;

  private int minFlipsMonoIncrRecursionMemoization(String s) {
    int size = s.length();
    dp = new int[size + 1][2];
    for (int i = 0; i < size; i++) {
      Arrays.fill(dp[i], -1);
    }
    return solveRecursionMemoization(s.toCharArray(), 0, 0);
  }

  private int solveRecursionMemoization(char[] chars, int previous, int currentIndex) {
    int flipCount = Integer.MAX_VALUE;
    int nonFlipCount = Integer.MAX_VALUE;
    if (currentIndex >= chars.length) {
      return 0;
    }
    if (dp[currentIndex][previous] != -1) {
      return dp[currentIndex][previous];
    }
    if (chars[currentIndex] == '0') {
      if (previous == 1) {
        // 1, 0
        flipCount = 1 + solveRecursionMemoization(chars, 1, currentIndex + 1);
      } else {
        // 0, 0
        flipCount = 1 + solveRecursionMemoization(chars, 1, currentIndex + 1);
        nonFlipCount = solveRecursionMemoization(chars, 0, currentIndex + 1);
      }
    } else {
      // current char = 1
      if (previous == 1) {
        // 1, 1
        nonFlipCount = solveRecursionMemoization(chars, 1, currentIndex + 1);
      } else {
        // 0, 1
        flipCount = 1 + solveRecursionMemoization(chars, 0, currentIndex + 1);
        nonFlipCount = solveRecursionMemoization(chars, 1, currentIndex + 1);
      }
    }
    return dp[currentIndex][previous] = Math.min(flipCount, nonFlipCount);
  }

  private int minFlipsMonoIncrRecursion(String s) {
    char[] chars = s.toCharArray();
    return solveRecursion(chars, 0, 0);
  }

  private int solveRecursion(char[] chars, int previous, int currentIndex) {
    int flipCount = Integer.MAX_VALUE;
    int nonFlipCount = Integer.MAX_VALUE;
    if (currentIndex >= chars.length) {
      return 0;
    }
    if (chars[currentIndex] == '0') {
      if (previous == 1) {
        // 1, 0
        flipCount = 1 + solveRecursion(chars, 1, currentIndex + 1);
      } else {
        // 0, 0
        flipCount = 1 + solveRecursion(chars, 1, currentIndex + 1);
        nonFlipCount = solveRecursion(chars, 0, currentIndex + 1);
      }
    } else {
      // current char = 1
      if (previous == 1) {
        // 1, 1
        nonFlipCount = solveRecursion(chars, 1, currentIndex + 1);
      } else {
        // 0, 1
        flipCount = 1 + solveRecursion(chars, 0, currentIndex + 1);
        nonFlipCount = solveRecursion(chars, 1, currentIndex + 1);
      }
    }
    return Math.min(flipCount, nonFlipCount);
  }
}