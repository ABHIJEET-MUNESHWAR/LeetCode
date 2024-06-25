package com.leetcode.medium.dynamicprogramming.twodimension;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    21/06/24,
 * Time:    2:46 pm
 * 1035. Uncrossed Lines
 * https://leetcode.com/problems/uncrossed-lines/description/
 */
public class UncrossedLines {
  public static void main(String[] args) {
    UncrossedLines uncrossedLines = new UncrossedLines();
    int[] nums1 = {1, 4, 2};
    int[] nums2 = {1, 2, 4};
    System.out.println(uncrossedLines.maxUncrossedLinesRecursion(nums1, nums2));
    System.out.println(uncrossedLines.maxUncrossedLinesRecursionMemoization(nums1, nums2));
    System.out.println(uncrossedLines.maxUncrossedLinesBottomUp(nums1, nums2));
  }

  private int maxUncrossedLinesBottomUp(int[] nums1, int[] nums2) {
    int size1 = nums1.length;
    int size2 = nums2.length;
    int[][] dp = new int[size1 + 1][size2 + 1];
    dp[0][0] = 0;
    for (int i = 1; i <= size1; i++) {
      for (int j = 1; j <= size2; j++) {
        if (nums1[i - 1] == nums2[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[size1][size2];
  }

  int[][] dp;

  private int maxUncrossedLinesRecursionMemoization(int[] nums1, int[] nums2) {
    dp = new int[nums1.length][nums2.length];
    for (int i = 0; i < nums1.length; i++) {
      Arrays.fill(dp[i], -1);
    }
    return solveRecursionMemoization(nums1, nums2, 0, 0);
  }

  private int solveRecursionMemoization(int[] nums1, int[] nums2, int i, int j) {
    if (i == nums1.length || j == nums2.length) {
      return 0;
    }
    if (dp[i][j] != -1) {
      return dp[i][j];
    }
    if (nums1[i] == nums2[j]) {
      return dp[i][j] = 1 + solveRecursionMemoization(nums1, nums2, i + 1, j + 1);
    } else {
      return dp[i][j] = Math.max(solveRecursionMemoization(nums1, nums2, i + 1, j), solveRecursionMemoization(nums1, nums2, i, j + 1));
    }
  }

  private int maxUncrossedLinesRecursion(int[] nums1, int[] nums2) {
    return solveRecursion(nums1, nums2, 0, 0);
  }

  private int solveRecursion(int[] nums1, int[] nums2, int i, int j) {
    if (i == nums1.length || j == nums2.length) {
      return 0;
    }
    if (nums1[i] == nums2[j]) {
      return 1 + solveRecursion(nums1, nums2, i + 1, j + 1);
    } else {
      return Math.max(solveRecursion(nums1, nums2, i + 1, j), solveRecursion(nums1, nums2, i, j + 1));
    }
  }
}