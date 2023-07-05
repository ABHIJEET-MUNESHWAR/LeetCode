package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    05/07/23,
 * Time:    11:31 am
 * https://leetcode.com/problems/find-the-highest-altitude/
 */
public class HighestAltitude {
  public static void main(String[] args) {
    HighestAltitude highestAltitude = new HighestAltitude();
    int[] gain = {-5, 1, 5, 0, -7};
    System.out.println(highestAltitude.largestAltitude(gain));
  }

  private int largestAltitude(int[] gain) {
    int max = 0;
    int prefixSum = 0;
    for (int height : gain) {
      prefixSum += height;
      if (max < prefixSum) {
        max = prefixSum;
      }
    }
    return max;
  }
}