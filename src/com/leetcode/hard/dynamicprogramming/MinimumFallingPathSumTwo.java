package com.leetcode.hard.dynamicprogramming;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    26/04/24,
 * Time:    7:24 am
 * 1289. Minimum Falling Path Sum II
 * https://leetcode.com/problems/minimum-falling-path-sum-ii/description/
 */
public class MinimumFallingPathSumTwo {
  public static void main(String[] args) {
    MinimumFallingPathSumTwo minimumFallingPathSumTwo = new MinimumFallingPathSumTwo();
    int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    System.out.println(minimumFallingPathSumTwo.minFallingPathSum(grid));
  }

  private int minFallingPathSum(int[][] grid) {
    int n = grid.length;
    for (int row = n - 2; row >= 0; row--) {
      for (int col = 0; col < n; col++) {
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < col; k++) {
          min = Math.min(min, grid[row + 1][k]);
        }
        for (int k = col+1; k < n; k++) {
          min = Math.min(min, grid[row + 1][k]);
        }
        grid[row][col] += min;
      }
    }
    int answer = Integer.MAX_VALUE;
    for (int col = 0; col < n; col++) {
      answer = Math.min(answer, grid[0][col]);
    }
    return answer;
  }
}