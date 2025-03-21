package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    09/03/24,
 * Time:    4:21 pm
 * https://leetcode.com/problems/find-champion-i/
 */
public class FindChampion {
  public static void main(String[] args) {
    FindChampion findChampion = new FindChampion();
    int[][] grid = {{0, 0, 1}, {1, 0, 1}, {0, 0, 0}};
    System.out.println(findChampion.findChampion(grid));
  }

  private int findChampion(int[][] grid) {
    int row = grid.length;
    int column = grid[0].length;
    for (int i = 0; i < row; i++) {
      int count = 0;
      for (int j = 0; j < column; j++) {
        if (grid[i][j] == 1) {
          count++;
        }
        if (count == row - 1) {
          return i;
        }
      }
    }
    return -1;
  }
}