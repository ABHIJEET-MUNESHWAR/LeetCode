package com.leetcode.medium.dynamicprogramming.twodimension;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    25/06/24,
 * Time:    6:52 pm
 * 799. Champagne Tower
 * https://leetcode.com/problems/champagne-tower/description/
 */
public class ChampagneTower {
  public static void main(String[] args) {
    ChampagneTower champagneTower = new ChampagneTower();
    int poured = 100000009, query_row = 33, query_glass = 17;
    System.out.println(champagneTower.champagneTowerRecursion(poured, query_row, query_glass));
    System.out.println(champagneTower.champagneTowerRecursionMemoization(poured, query_row, query_glass));
    System.out.println(champagneTower.champagneTowerBottomUp(poured, query_row, query_glass));
  }

  private double champagneTowerBottomUp(int poured, int queryRow, int queryGlass) {
    double[][] dp = new double[101][101];
    dp[0][0] = poured;
    for (int row = 0; row <= queryRow; row++) {
      for (int col = 0; col <= row; col++) {
        double extra = (dp[row][col] - 1) / 2;
        if (extra > 0) {
          dp[row + 1][col + 1] += extra;
          dp[row + 1][col] += extra;
        }
      }
    }
    return Math.min(1, dp[queryRow][queryGlass]);
  }

  double[][] dp;

  private double champagneTowerRecursionMemoization(int poured, int queryRow, int queryGlass) {
    dp = new double[101][101];
    for (int i = 0; i < 101; i++) {
      Arrays.fill(dp[i], -1);
    }
    return Math.min(1.0, solveRecursionMemoization(poured, queryRow, queryGlass));
  }

  private double solveRecursionMemoization(int poured, int i, int j) {
    if (i < 0 || j > i || j < 0) {
      return 0.0;
    }

    if (i == 0 && j == 0) {
      return dp[i][j] = poured;
    }

    if (dp[i][j] != -1) {
      return dp[i][j];
    }

    double up_left = (solveRecursionMemoization(poured, i - 1, j - 1) - 1) / 2.0;
    double up_right = (solveRecursionMemoization(poured, i - 1, j) - 1) / 2.0;

    if (up_left < 0) {
      up_left = 0.0;
    }

    if (up_right < 0) {
      up_right = 0.0;
    }

    return dp[i][j] = up_left + up_right;
  }

  private double champagneTowerRecursion(int poured, int queryRow, int queryGlass) {
    return Math.min(1.0, solveRecursion(poured, queryRow, queryGlass));
  }

  private double solveRecursion(int poured, int i, int j) {
    if (i < 0 || j < 0 || i < j) {
      return 0.0;
    }
    if (i == 0 && j == 0) {
      return poured;
    }
    double leftUp = (solveRecursion(poured, i - 1, j - 1) - 1) / 2.0;
    double rightUp = (solveRecursion(poured, i - 1, j) - 1) / 2.0;
    if (leftUp < 0) {
      leftUp = 0.0;
    }
    if (rightUp < 0) {
      rightUp = 0.0;
    }
    return leftUp + rightUp;
  }
}