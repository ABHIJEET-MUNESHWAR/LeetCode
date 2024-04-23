package com.leetcode.hard.stack;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    23/04/24,
 * Time:    6:19 pm
 * 84. Largest Rectangle in Histogram
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 */
public class LargestRectangleInHistogram {
  public static void main(String[] args) {
    LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
    int[] heights = {2, 1, 5, 6, 2, 3};
    System.out.println(largestRectangleInHistogram.largestRectangleArea(heights));
  }

  private int largestRectangleArea(int[] heights) {
    int maxArea = Integer.MIN_VALUE;
    int size = heights.length;
    int[] stack = new int[size + 1];
    int index = -1;
    for (int i = 0; i <= size; i++) {
      int element = (i == size) ? 0 : heights[i];
      while ((index != -1) && ((heights[stack[index]]) > element)) {
        int h = heights[stack[index--]];
        int ps = (index == -1) ? -1 : stack[index];
        int w = i - ps - 1;
        maxArea = Math.max(maxArea, h * w);
      }
      stack[++index] = i;
    }
    return maxArea == Integer.MIN_VALUE ? 0 : maxArea;
  }
}