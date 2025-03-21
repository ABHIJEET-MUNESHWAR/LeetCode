package com.leetcode.medium.array;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    06/05/24,
 * Time:    9:16 pm
 * 2482. Difference Between Ones and Zeros in Row and Column
 * https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/description/
 */
public class OnesMinusZeros {
  public static void main(String[] args) {
    OnesMinusZeros onesMinusZeros = new OnesMinusZeros();
    int[][] grid = {{0, 1, 1}, {1, 0, 1}, {0, 0, 1}};
    ArrayUtils.printMatrix(onesMinusZeros.onesMinusZeros(grid));
  }

  private int[][] onesMinusZeros(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    int[] onceRows = new int[rows];
    int[] onceCols = new int[cols];
    int[] zerosRows = new int[rows];
    int[] zerosCols = new int[cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == 1) {
          onceRows[i]++;
          onceCols[j]++;
        } else {
          zerosRows[i]++;
          zerosCols[j]++;
        }
      }
    }
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        grid[i][j] = onceRows[i] + onceCols[j] - zerosRows[i] - zerosCols[j];
      }
    }
    return grid;
  }
}