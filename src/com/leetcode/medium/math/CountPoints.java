package com.leetcode.medium.math;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    02/05/24,
 * Time:    6:27 pm
 * 1828. Queries on Number of Points Inside a Circle
 * https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/description/
 */
public class CountPoints {
  public static void main(String[] args) {
    CountPoints countPoints = new CountPoints();
    int[][] points = {{1, 3}, {3, 3}, {5, 3}, {2, 2}};
    int[][] queries = {{2, 3, 1}, {4, 3, 1}, {1, 1, 2}};
    ArrayUtils.printArray(countPoints.countPoints(points, queries));
  }

  private int[] countPoints(int[][] points, int[][] queries) {
    int[] res = new int[queries.length];
    int i = 0;
    for (int[] query : queries) {
      int pts = 0;
      for (int[] point : points) {
        if ((point[0] - query[0]) * (point[0] - query[0]) + (point[1] - query[1]) * (point[1] - query[1]) <= query[2] * query[2]) {
          pts++;
        }
      }
      res[i++] = pts;
    }
    return res;
  }
}