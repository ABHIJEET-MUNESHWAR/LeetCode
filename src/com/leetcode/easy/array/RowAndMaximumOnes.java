package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    24/09/23,
 * Time:    5:21 pm
 * https://leetcode.com/problems/row-with-maximum-ones/
 */
public class RowAndMaximumOnes {
  public static void main(String[] args) {
    RowAndMaximumOnes rowAndMaximumOnes = new RowAndMaximumOnes();
    int[][] mat = {{0, 0}, {1, 1}, {0, 0}};
    ArrayUtils.printArray(rowAndMaximumOnes.rowAndMaximumOnes(mat));
  }

  private int[] rowAndMaximumOnes(int[][] mat) {
    int rowNo = 0, maxCount = Integer.MIN_VALUE;
    int row = mat.length;
    int col = mat[0].length;
    for (int i = 0; i < row; i++) {
      int once = 0;
      for (int j = 0; j < col; j++) {
        if (mat[i][j] == 1) {
          once++;
        }
      }
      if (maxCount < once) {
        maxCount = once;
        rowNo = i;
      }
    }
    return new int[]{rowNo,maxCount};
  }
}