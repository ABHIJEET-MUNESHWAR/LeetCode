package com.leetcode.medium.dynamicprogramming.twodimension;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    26/06/24,
 * Time:    9:03 pm
 * 1155. Number of Dice Rolls With Target Sum
 * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/description/
 */
public class NumberOfDiceRollsWithTargetSum {
  public static void main(String[] args) {
    NumberOfDiceRollsWithTargetSum numberOfDiceRollsWithTargetSum = new NumberOfDiceRollsWithTargetSum();
    int n = 1, k = 6, target = 3;
    System.out.println(numberOfDiceRollsWithTargetSum.numRollsToTargetRecursion(n, k, target));
    System.out.println(numberOfDiceRollsWithTargetSum.numRollsToTargetRecursionMemoization(n, k, target));
    System.out.println(numberOfDiceRollsWithTargetSum.numRollsToTargetBottomUp(n, k, target));
  }

  private int numRollsToTargetBottomUp(int n, int k, int target) {
    int[][] dp = new int[n + 1][target + 1];
    // State definition: dp[i][j] Number of ways to obtain sum=j if we've i dices
    dp[0][0] = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= target; j++) {
        for (int face = 1; face <= k; face++) {
          if (face <= j) {
            dp[i][j] = (dp[i][j] + dp[i - 1][j - face]) % mod;
          }
        }
      }
    }
    return dp[n][target];
  }

  int mod = 1000000007;
  int[][] dp;

  private int numRollsToTargetRecursionMemoization(int n, int k, int target) {
    dp = new int[32][1002];
    for (int i = 0; i < 32; i++) {
      Arrays.fill(dp[i], -1);
    }
    return solveRecursionMemoization(n, k, target);
  }

  private int solveRecursionMemoization(int n, int k, int target) {
    if (target < 0 || n == 0) {
      return target == 0 ? 1 : 0;
    }
    if (dp[n][target] != -1) {
      return dp[n][target];
    }
    int sum = 0;
    for (int face = 1; face <= k; face++) {
      sum = (sum + solveRecursionMemoization(n - 1, k, target - face)) % mod;
    }
    return dp[n][target] = sum;
  }


  private int numRollsToTargetRecursion(int n, int k, int target) {
    return solveRecursion(n, k, target);
  }

  private int solveRecursion(int n, int k, int target) {
    if (target < 0 || n == 0) {
      return (target == 0 ? 1 : 0);
    }
    int sum = 0;
    for (int face = 1; face <= k; face++) {
      sum = (sum + solveRecursion(n - 1, k, target - face)) % mod;
    }
    return sum;
  }
}