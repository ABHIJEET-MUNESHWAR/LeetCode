package com.leetcode.easy.greedy;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    08/10/23,
 * Time:    6:22pm
 * https://leetcode.com/problems/maximum-units-on-a-truck/
 */
public class MaximumUnits {
  public static void main(String[] args) {
    MaximumUnits maximumUnits = new MaximumUnits();
    int[][] boxTypes = {{1, 3}, {2, 2}, {3, 1}};
    int truckSize = 4;
    System.out.println(maximumUnits.maximumUnits(boxTypes, truckSize));
  }

  private int maximumUnits(int[][] boxTypes, int truckSize) {
    int totalUnits = 0;
    Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
    for (int[] boxType : boxTypes) {
      int numberOfBoxes = boxType[0];
      int numberOfUnitsPerBox = boxType[1];
      int count = Math.min(truckSize, numberOfBoxes);
      totalUnits+=count*numberOfUnitsPerBox;
      truckSize-=count;
      if(truckSize==0){
        return totalUnits;
      }
    }
    return totalUnits;
  }
}