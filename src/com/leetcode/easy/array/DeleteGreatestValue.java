package com.leetcode.easy.array;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    28/08/23,
 * Time:    1:50 pm
 * https://leetcode.com/problems/delete-greatest-value-in-each-row/
 */
public class DeleteGreatestValue {
  public static void main(String[] args) {
    DeleteGreatestValue deleteGreatestValue = new DeleteGreatestValue();
    int[][] grid = {{1, 2, 4}, {3, 3, 1}};
    System.out.println(deleteGreatestValue.deleteGreatestValue(grid));
  }

  private int deleteGreatestValue(int[][] grid) {
    int total = 0;
    int row = grid.length;
    int col = grid[0].length;
    for (int i = 0; i < row; i++) {
      Arrays.sort(grid[i]);
    }
    for (int i = 0; i < col; i++) {
      int max = 0;
      for (int j = 0; j < row; j++) {
        max = Math.max(max, grid[j][i]);
      }
      total += max;
    }
    return total;
  }
}