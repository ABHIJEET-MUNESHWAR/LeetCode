package com.leetcode.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    31/08/22, Time:    10:11 AM
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 */
public class PacificAtlanticWaterFlow {

  int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public static void main(String[] args) {
    PacificAtlanticWaterFlow pacificAtlanticWaterFlow = new PacificAtlanticWaterFlow();
    int[][] heights = {
        {1, 2, 2, 3, 5},
        {3, 2, 3, 4, 4},
        {2, 4, 5, 3, 1},
        {6, 7, 1, 4, 5},
        {5, 1, 1, 2, 4}
    };
    List<List<Integer>> result = pacificAtlanticWaterFlow.pacificAtlantic(heights);
  }

  private List<List<Integer>> pacificAtlantic(int[][] heights) {
    int rows = heights.length;
    int cols = heights[0].length;
    List<List<Integer>> result = new ArrayList<>();
    if (heights == null || rows == 0 || cols == 0) {
      return result;
    }
    boolean[][] pacific = new boolean[rows][cols];
    boolean[][] atlantic = new boolean[rows][cols];
    //dfs
    for (int i = 0; i < rows; i++) {
      dfs(heights, i, 0, Integer.MIN_VALUE, pacific, rows, cols);
      dfs(heights, i, cols - 1, Integer.MIN_VALUE, atlantic, rows, cols);
    }
    for (int i = 0; i < cols; i++) {
      dfs(heights, 0, i, Integer.MIN_VALUE, pacific, rows, cols);
      dfs(heights, rows - 1, i, Integer.MIN_VALUE, atlantic, rows, cols);
    }

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (pacific[i][j] && atlantic[i][j]) {
          result.add(Arrays.asList(i, j));
        }
      }
    }
    return result;
  }

  public void dfs(int[][] heights, int i, int j, int prev, boolean[][] ocean, int rows, int cols) {
    if (i < 0 || j < 0 || i >= rows || j >= cols || ocean[i][j] || heights[i][j] < prev) {
      return;
    }
    ocean[i][j] = true;
    for (int[] d : dir) {
      dfs(heights, i + d[0], j + d[1], heights[i][j], ocean, rows, cols);
    }
  }
}