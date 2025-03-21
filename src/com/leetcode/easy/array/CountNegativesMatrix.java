package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    17/09/23,
 * Time:    11:21 pm
 * https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
 */
public class CountNegativesMatrix {
  public static void main(String[] args) {
    CountNegativesMatrix countNegativesMatrix = new CountNegativesMatrix();
    int[][] grid = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
    System.out.println(countNegativesMatrix.countNegativesMatrix(grid));
  }

  private int countNegativesMatrix(int[][] grid) {
    int count = 0;
    int row = grid.length;
    int col = grid[0].length;
    int r = row - 1, c = 0;
    while (r >= 0 && c < col) {
      if (grid[r][c] < 0) {
        count += col - c;
        r--;
      } else {
        c++;
      }
    }
    return count;
  }
}