package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    15/10/23,
 * Time:    10:56am
 * https://leetcode.com/problems/projection-area-of-3d-shapes/
 */
public class ProjectionArea {
  public static void main(String[] args) {
    ProjectionArea projectionArea = new ProjectionArea();
    int[][] grid = {{1, 2}, {3, 4}};
    System.out.println(projectionArea.projectionArea(grid));
  }

  private int projectionArea(int[][] grid) {
    int result = 0;
    int size = grid.length;
    for (int i = 0; i < size; i++) {
      int x = 0, y = 0;
      for (int j = 0; j < size; j++) {
        x = Math.max(x, grid[i][j]);
        y = Math.max(y, grid[j][i]);
        if (grid[i][j] > 0) {
          result++;
        }
      }
      result += x + y;
    }
    return result;
  }
}