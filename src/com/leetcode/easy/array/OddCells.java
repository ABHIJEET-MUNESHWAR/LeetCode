package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    08/09/23,
 * Time:    9:19 am
 * https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
 */
public class OddCells {
  public static void main(String[] args) {
    OddCells oddCells = new OddCells();
    int m = 2, n = 3;
    int[][] indices = {{0, 1}, {1, 1}};
    System.out.println(oddCells.oddCells(m, n, indices));
  }

  private int oddCells(int m, int n, int[][] indices) {
    int count = 0;
    int[][] matrix = new int[m][n];
    for (int i = 0; i < indices.length; i++) {
      int row = indices[i][0];
      int col = indices[i][1];
      for (int j = 0; j < n; j++) {
        matrix[row][j]++;
      }
      for (int j = 0; j < m; j++) {
        matrix[j][col]++;
      }
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] % 2 == 1) {
          count++;
        }
      }
    }
    return count;
  }
}