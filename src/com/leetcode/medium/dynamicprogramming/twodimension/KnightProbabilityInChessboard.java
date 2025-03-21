package com.leetcode.medium.dynamicprogramming.twodimension;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    23/06/24,
 * Time:    7:02 pm
 * 688. Knight Probability in Chessboard
 * https://leetcode.com/problems/knight-probability-in-chessboard/description/
 */
public class KnightProbabilityInChessboard {
  public static void main(String[] args) {
    KnightProbabilityInChessboard knightProbabilityInChessboard = new KnightProbabilityInChessboard();
    int n = 3, k = 2, row = 0, column = 0;
    System.out.println(knightProbabilityInChessboard.knightProbabilityRecursion(n, k, row, column));
    System.out.println(knightProbabilityInChessboard.knightProbabilityRecursionMemoization(n, k, row, column));
  }

  int[][] direction = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};


  Map<String, Double> dpMap = new HashMap<>();

  private double knightProbabilityRecursionMemoization(int n, int k, int row, int column) {
    return solveRecursionMemoization(n, k, row, column);
  }

  private double solveRecursionMemoization(int n, int k, int row, int column) {
    if (row < 0 || row >= n || column < 0 || column >= n) {
      return 0;
    }
    if (k == 0) {
      return 1;
    }
    String key = "row_" + row + "_column_" + column + "_key_" + k;
    if (dpMap.containsKey(key)) {
      return dpMap.get(key);
    }
    double result = 0;
    for (int[] direction : direction) {
      result += (double) solveRecursionMemoization(n, k - 1, row + direction[0], column + direction[1]);
    }
    dpMap.put(key, (double) result / 8.0);
    return (double) result / 8.0;
  }

  private double knightProbabilityRecursion(int n, int k, int row, int column) {
    return solveRecursion(n, k, row, column);
  }

  private double solveRecursion(int n, int k, int row, int column) {
    if (row < 0 || row >= n || column < 0 || column >= n) {
      return 0;
    }
    if (k == 0) {
      return 1;
    }
    double result = 0;
    for (int[] direction : direction) {
      result += (double) solveRecursion(n, k - 1, row + direction[0], column + direction[1]);
    }
    return (double) result / 8.0;
  }
}