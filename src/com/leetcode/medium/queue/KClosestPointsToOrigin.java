package com.leetcode.medium.queue;

import com.leetcode.utils.ArrayUtils;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    03/06/24,
 * Time:    10:18 pm
 * 973. K Closest Points to Origin
 * https://leetcode.com/problems/k-closest-points-to-origin/description/
 */
public class KClosestPointsToOrigin {
  public static void main(String[] args) {
    KClosestPointsToOrigin kClosestPointsToOrigin = new KClosestPointsToOrigin();
    int[][] points = {{1, 3}, {-2, 2}};
    int k = 1;
    ArrayUtils.printMatrix(kClosestPointsToOrigin.kClosest(points, k));
  }

  private int[][] kClosest(int[][] points, int k) {
    Arrays.sort(points, Comparator.comparing(p -> p[0] * p[0] + p[1] * p[1]));
    return Arrays.copyOfRange(points, 0, k);
  }
}