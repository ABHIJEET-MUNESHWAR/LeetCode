package com.leetcode.medium.dynamicprogramming;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    21/06/24,
 * Time:    3:29 pm
 * 2140. Solving Questions With Brainpower
 * https://leetcode.com/problems/solving-questions-with-brainpower/description/
 */
public class SolvingQuestionsWithBrainpower {
  public static void main(String[] args) {
    SolvingQuestionsWithBrainpower solvingQuestionsWithBrainpower = new SolvingQuestionsWithBrainpower();
    int[][] questions = {{3, 2}, {4, 3}, {4, 4}, {2, 5}};
    System.out.println(solvingQuestionsWithBrainpower.mostPointsRecursion(questions));
    System.out.println(solvingQuestionsWithBrainpower.mostPointsRecursionMemoization(questions));
    System.out.println(solvingQuestionsWithBrainpower.mostPointsBottomUp(questions));
  }

  private long mostPointsBottomUp(int[][] questions) {
    int size = questions.length;
    long[] dp = new long[200001];
    // State definition
    // dp[i] = maximum points earned by question from ith index to n-1 index.
    for (int i = size - 1; i >= 0; i--) {
      dp[i] = Math.max(questions[i][0] + dp[i + questions[i][1] + 1], dp[i + 1]);
    }
    return dp[0];
  }

  long[] dp;

  private long mostPointsRecursionMemoization(int[][] questions) {
    dp = new long[questions.length + 1];
    Arrays.fill(dp, -1L);
    return solveRecursionMemoization(questions, 0);
  }

  private long solveRecursionMemoization(int[][] questions, int index) {
    if (index >= questions.length) {
      return 0;
    }
    if (dp[index] != -1) {
      return dp[index];
    }
    long take = questions[index][0] + solveRecursionMemoization(questions, index + questions[index][1] + 1);
    long skip = solveRecursionMemoization(questions, index + 1);
    return dp[index] = Math.max(take, skip);
  }

  private long mostPointsRecursion(int[][] questions) {
    return solveRecursion(questions, 0);
  }

  private long solveRecursion(int[][] questions, int index) {
    if (index >= questions.length) {
      return 0;
    }
    long take = questions[index][0] + solveRecursion(questions, index + questions[index][1] + 1);
    long skip = solveRecursion(questions, index + 1);
    return Math.max(take, skip);
  }
}