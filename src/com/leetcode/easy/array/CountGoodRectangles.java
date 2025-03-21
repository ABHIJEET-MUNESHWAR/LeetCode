package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    03/09/23,
 * Time:    7:56 pm
 * https://leetcode.com/problems/number-of-rectangles-that-can-form-the-largest-square/
 */
public class CountGoodRectangles {
  public static void main(String[] args) {
    CountGoodRectangles countGoodRectangles = new CountGoodRectangles();
    int[][] rectangles = {{5, 8}, {3, 9}, {5, 12}, {16, 5}};
    System.out.println(countGoodRectangles.countGoodRectangles(rectangles));
  }

  private int countGoodRectangles(int[][] rectangles) {
    int count = 0;
    int row = rectangles.length;
    int[] squares = new int[row];
    for (int i = 0; i < row; i++) {
      squares[i] = Math.min(rectangles[i][0], rectangles[i][1]);
    }
    int max = 0;
    for (int i = 0; i < row; i++) {
      if (max < squares[i]) {
        max = squares[i];
      }
    }
    for (int i = 0; i < row; i++) {
      if (max == squares[i]) {
        count++;
      }
    }
    return count;
  }
}