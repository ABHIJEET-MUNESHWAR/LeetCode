package com.leetcode.medium.dynamicprogramming.gamestrategy;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    22/06/24,
 * Time:    5:26 pm
 * 1140. Stone Game II
 * https://leetcode.com/problems/stone-game-ii/description/
 */
public class StoneGameTwo {
  public static void main(String[] args) {
    StoneGameTwo stoneGameTwo = new StoneGameTwo();
    int[] piles = {2, 7, 9, 4, 4};
    System.out.println(stoneGameTwo.stoneGameIIRecursion(piles));
    System.out.println(stoneGameTwo.stoneGameIIRecursionMemoization(piles));
  }

  int[][][] dp;

  private int stoneGameIIRecursionMemoization(int[] piles) {
    dp = new int[2][101][101];
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 101; j++) {
        for (int k = 0; k < 101; k++) {
          dp[i][j][k] = -1;
        }
      }
    }
    return solveForAliceRecursionMemoization(piles, 1, 0, 1);
  }

  private int solveForAliceRecursionMemoization(int[] piles, int person, int index, int m) {
    if (index >= piles.length) {
      return 0;
    }
    if (dp[person][index][m] != -1) {
      return dp[person][index][m];
    }
    int result = person == 1 ? -1 : Integer.MAX_VALUE;
    int stones = 0;
    for (int x = 1; x <= Math.min(2 * m, piles.length - index); x++) {
      stones += piles[index + x - 1];
      if (person == 1) {
        // Alice
        result = Math.max(result, stones + solveForAliceRecursionMemoization(piles, 0, index + x, Math.max(x, m)));
      } else {
        // Bob
        result = Math.min(result, solveForAliceRecursionMemoization(piles, 1, index + x, Math.max(x, m)));
      }
    }
    return dp[person][index][m] = result;
  }

  private int stoneGameIIRecursion(int[] piles) {
    return solveForAliceRecursion(piles, 1, 0, 1);
  }

  private int solveForAliceRecursion(int[] piles, int person, int index, int m) {
    if (index >= piles.length) {
      return 0;
    }
    int result = person == 1 ? -1 : Integer.MAX_VALUE;
    int stones = 0;
    for (int x = 1; x <= Math.min(2 * m, piles.length - index); x++) {
      stones += piles[index + x - 1];
      if (person == 1) {
        // Alice
        result = Math.max(result, stones + solveForAliceRecursion(piles, 0, index + x, Math.max(x, m)));
      } else {
        // Bob
        result = Math.min(result, solveForAliceRecursion(piles, 1, index + x, Math.max(x, m)));
      }
    }
    return result;
  }
}