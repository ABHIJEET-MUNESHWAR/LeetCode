package com.leetcode.medium.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    08/04/24,
 * Time:    11:56 am
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/?envType=daily-question&envId=2024-03-18
 */
public class FindMinArrowShots {
  public static void main(String[] args) {
    FindMinArrowShots findMinArrowShots = new FindMinArrowShots();
    int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
    System.out.println(findMinArrowShots.findMinArrowShots(points));
  }

  private int findMinArrowShots(int[][] points) {
    int arrowsCount = 1;
    int size = points.length;
    if (size == 1) {
      return 1;
    }
    Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
    int commonEndPoint = points[0][1];
    for (int i = 1; i < size; i++) {
      int currentStart = points[i][0];
      int currentEnd = points[i][1];
      if (commonEndPoint < currentStart) {
        commonEndPoint = currentEnd;
        arrowsCount++;
      }
    }
    return arrowsCount;
  }
}