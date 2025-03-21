package com.leetcode.easy.geometry;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    30/08/23,
 * Time:    10:11 pm
 * https://leetcode.com/problems/minimum-time-visiting-all-points/
 */
public class MinTimeToVisitAllPoints {
  public static void main(String[] args) {
    MinTimeToVisitAllPoints minTimeToVisitAllPoints = new MinTimeToVisitAllPoints();
    int[][] points = {{1, 1}, {3, 4}, {-1, 0}};
    System.out.println(minTimeToVisitAllPoints.minTimeToVisitAllPoints(points));
  }

  private int minTimeToVisitAllPoints(int[][] points) {
    int minDistance = 0;
    int row = points.length;
    for (int i = 1; i < row; i++) {
      minDistance += Math.max(Math.abs(points[i][0] - points[i - 1][0]),
          Math.abs(points[i][1] - points[i - 1][1]));
    }
    return minDistance;
  }
}