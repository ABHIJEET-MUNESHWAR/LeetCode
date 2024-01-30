package com.leetcode.easy.array;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    30/01/24,
 * Time:    8:01 am
 * https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/
 */
public class MaxWidthOfVerticalArea {
  public static void main(String[] args) {
    MaxWidthOfVerticalArea maxWidthOfVerticalArea = new MaxWidthOfVerticalArea();
    int[][] points = {{3, 1}, {9, 0}, {1, 0}, {1, 4}, {5, 3}, {8, 8}};
    System.out.println(maxWidthOfVerticalArea.maxWidthOfVerticalArea(points));
  }

  private int maxWidthOfVerticalArea(int[][] points) {
    int maxDiff = Integer.MIN_VALUE;
    Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
    for (int i = 1; i < points.length; i++) {
      int diff = points[i][0] - points[i - 1][0];
      maxDiff = Math.max(diff, maxDiff);
    }
    return maxDiff;
  }
}