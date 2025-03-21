package com.leetcode.hard.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    23/04/24,
 * Time:    6:46 pm
 * 85. Maximal Rectangle
 * https://leetcode.com/problems/maximal-rectangle/description/?envType=daily-question&envId=2024-04-13
 */
public class MaximalRectangle {
  public static void main(String[] args) {
    MaximalRectangle maximalRectangle = new MaximalRectangle();
    char[][] matrix =
        {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0'
            , '0', '1', '0'}};
    System.out.println(maximalRectangle.maximalRectangle(matrix));
  }

  private int maximalRectangle(char[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    int[] heights = new int[matrix[0].length];
    int largestArea = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        int val = matrix[i][j] - '0';
        if (val == 0) {
          heights[j] = 0;
        } else {
          heights[j] += val;
        }
      }
      int maxArea = largestRectangleArea(heights);
      largestArea = Math.max(maxArea, largestArea);
    }
    return largestArea;
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