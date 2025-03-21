package com.leetcode.medium.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    02/05/24,
 * Time:    8:52 pm
 * 807. Max Increase to Keep City Skyline
 * https://leetcode.com/problems/max-increase-to-keep-city-skyline/
 */
public class MaxIncreaseKeepingSkyline {
  public static void main(String[] args) {
    MaxIncreaseKeepingSkyline maxIncreaseKeepingSkyline = new MaxIncreaseKeepingSkyline();
    int[][] grid = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
    System.out.println(maxIncreaseKeepingSkyline.maxIncreaseKeepingSkyline(grid));
  }

  private int maxIncreaseKeepingSkyline(int[][] grid) {
    int answer = 0;
    int n = grid.length;
    int[] rowMaxArray = new int[n];
    int[] colMaxArray = new int[n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        rowMaxArray[i] = Math.max(rowMaxArray[i], grid[i][j]);
        colMaxArray[j] = Math.max(colMaxArray[j], grid[i][j]);
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int raise = Math.min(rowMaxArray[i], colMaxArray[j]) - grid[i][j];
        answer += raise;
      }
    }
    return answer;
  }
}