package com.leetcode.easy.math;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    05/06/23,
 * Time:    11:08 am
 * https://leetcode.com/problems/check-if-it-is-a-straight-line/
 */
public class CheckStraightLine {
  public static void main(String[] args) {
    CheckStraightLine checkStraightLine = new CheckStraightLine();
    int[][] coordinates = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
    System.out.println(checkStraightLine.checkStraightLine(coordinates));
  }

  private boolean checkStraightLine(int[][] coordinates) {
    int x0 = coordinates[0][0];
    int x1 = coordinates[1][0];
    int y0 = coordinates[0][1];
    int y1 = coordinates[1][1];
    int dx = x1 - x0;
    int dy = y1 - y0;
    for (int[] co : coordinates) {
      int x = co[0];
      int y = co[1];
      if (dx * (y - y1) != (dy * (x - x1))) {
        return false;
      }
    }
    return true;
  }
}