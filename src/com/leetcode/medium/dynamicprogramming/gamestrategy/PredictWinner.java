package com.leetcode.medium.dynamicprogramming.gamestrategy;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    24/06/24,
 * Time:    8:30 am
 * 486. Predict the Winner
 * https://leetcode.com/problems/predict-the-winner/description/
 */
public class PredictWinner {
  public static void main(String[] args) {
    PredictWinner predictWinner = new PredictWinner();
    int[] nums = {1, 5, 2};
    System.out.println(predictWinner.predictTheWinnerRecursion(nums));
    System.out.println(predictWinner.predictTheWinnerRecursionMemoization(nums));
  }

  int[][] dp;

  private boolean predictTheWinnerRecursionMemoization(int[] nums) {
    int n = nums.length;
    if (n == 1) {
      return true;
    }
    dp = new int[n + 1][n + 1];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }
    int totalScore = 0;
    for (int num : nums) {
      totalScore += num;
    }
    int player1Score = solveRecursionMemoization(nums, 0, n - 1);
    int player2Score = totalScore - player1Score;
    return player1Score >= player2Score;
  }

  private int solveRecursionMemoization(int[] nums, int left, int right) {
    if (left > right) {
      return 0;
    }
    if (left == right) {
      return nums[left];
    }
    if (dp[left][right] != -1) {
      return dp[left][right];
    }
    int leftScore = nums[left] + Math.min(solveRecursionMemoization(nums, left + 2, right), solveRecursionMemoization(nums, left + 1, right - 1));
    int rightScore = nums[right] + Math.min(solveRecursionMemoization(nums, left, right - 2), solveRecursionMemoization(nums, left + 1, right - 1));
    return dp[left][right] = Math.max(leftScore, rightScore);
  }

  private boolean predictTheWinnerRecursion(int[] nums) {
    int n = nums.length;
    if (n == 1) {
      return true;
    }
    int totalScore = 0;
    for (int num : nums) {
      totalScore += num;
    }
    int player1Score = solveRecursion(nums, 0, n - 1);
    int player2Score = totalScore - player1Score;
    return player1Score >= player2Score;
  }

  private int solveRecursion(int[] nums, int left, int right) {
    if (left > right) {
      return 0;
    }
    if (left == right) {
      return nums[left];
    }
    int leftScore = nums[left] + Math.min(solveRecursion(nums, left + 2, right), solveRecursion(nums, left + 1, right - 1));
    int rightScore = nums[right] + Math.min(solveRecursion(nums, left, right - 2), solveRecursion(nums, left + 1, right - 1));
    return Math.max(leftScore, rightScore);
  }
}