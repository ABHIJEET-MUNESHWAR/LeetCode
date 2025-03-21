package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    24/03/23, Time:    1:16 pm
 * https://leetcode.com/problems/largest-local-values-in-a-matrix/
 */
public class LargestLocalValuesMatrix {

  public static void main(String[] args) {
    LargestLocalValuesMatrix largestLocalValuesMatrix = new LargestLocalValuesMatrix();
    int[][] grid = {{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}};
    int[][] ans = largestLocalValuesMatrix.largestLocalValuesMatrix(grid);
    ArrayUtils.printMatrix(ans);
  }

  private int[][] largestLocalValuesMatrix(int[][] grid) {
    int[][] ans = new int[grid.length - 2][grid.length - 2];
    for (int i = 0; i < ans.length; i++) {
      for (int j = 0; j < ans.length; j++) {
        int max = Integer.MIN_VALUE;
        for (int a = i; a < i + 3; a++) {
          for (int b = j; b < j + 3; b++) {
            if (max < grid[a][b]) {
              max = grid[a][b];
            }
          }
        }
        ans[i][j] = max;
      }
    }
    return ans;
  }
}