package com.leetcode.easy.math;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    15/10/23,
 * Time:    9:14pm
 * https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
 */
public class MinCostToMoveChips {
  public static void main(String[] args) {
    MinCostToMoveChips minCostToMoveChips = new MinCostToMoveChips();
    int[] position = {2, 2, 2, 3, 3};
    System.out.println(minCostToMoveChips.minCostToMoveChips(position));
  }

  private int minCostToMoveChips(int[] positions) {
    int oddParity = 0, evenParity = 0;
    for (int position : positions) {
      if (position % 2 == 0) {
        evenParity++;
      } else {
        oddParity++;
      }
    }
    return Math.min(oddParity, evenParity);
  }
}