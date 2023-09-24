package com.leetcode.easy.array;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    24/09/23,
 * Time:    4:02 pm
 * https://leetcode.com/problems/height-checker/
 */
public class HeightChecker {
  public static void main(String[] args) {
    HeightChecker heightChecker = new HeightChecker();
    int[] heights = {1, 1, 4, 2, 1, 3};
    System.out.println(heightChecker.heightChecker(heights));
  }

  private int heightChecker(int[] heights) {
    int mismatch = 0;
    int size = heights.length;
    int[] sortedHeight = new int[size];
    for (int i = 0; i < size; i++) {
      sortedHeight[i] = heights[i];
    }
    Arrays.sort(sortedHeight);
    for (int i = 0; i < size; i++) {
      if (sortedHeight[i] != heights[i]) {
        mismatch++;
      }
    }
    return mismatch;
  }
}