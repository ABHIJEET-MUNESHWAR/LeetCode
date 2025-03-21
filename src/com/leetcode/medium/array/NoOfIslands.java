package com.leetcode.medium.array;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    29/08/22, Time:    8:39 PM
 * https://leetcode.com/problems/number-of-islands/
 */
public class NoOfIslands {

  public static void main(String[] args) {
    NoOfIslands noOfIslands = new NoOfIslands();
    char[][] grid = {{'1', '1', '0', '0', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '1', '0', '0'},
        {'0', '0', '0', '1', '1'}};
    System.out.println("No of Islands: " + noOfIslands.numIslands(grid));
  }

  private int numIslands(char[][] grid) {
    int count = 0;
    int rows = grid.length;
    int cols = grid[0].length;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == '1') {
          DfsMarking(grid, i, j, rows, cols);
          count++;
        }
      }
    }
    return count;
  }

  private void DfsMarking(char[][] grid, int i, int j, int rows, int cols) {
    if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] != '1') {
      return;
    }
    grid[i][j] = '0';
    DfsMarking(grid, i - 1, j, rows, cols);
    DfsMarking(grid, i + 1, j, rows, cols);
    DfsMarking(grid, i, j - 1, rows, cols);
    DfsMarking(grid, i, j + 1, rows, cols);
  }
}