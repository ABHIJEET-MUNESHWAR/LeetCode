package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    27/11/22, Time:    1:10 pm
 * https://leetcode.com/problems/reshape-the-matrix/
 */
public class ReshapeMatrix {

  public static void main(String[] args) {
    int[][] mat = new int[][]{{1, 2}};
    ReshapeMatrix reshapeMatrix = new ReshapeMatrix();
    int r = 1, c = 1;
    int[][] reshapedMatrix = reshapeMatrix.matrixReshape(mat, r, c);
    ArrayUtils.printMatrix(reshapedMatrix);
  }

  private int[][] matrixReshape(int[][] mat, int r, int c) {
    int row = mat.length;
    int col = mat[0].length;
    if ((row * col) != (r * c)) {
      return mat;
    }
    int rowNo = 0;
    int colNo = 0;
    int[][] newMat = new int[r][c];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        newMat[rowNo][colNo] = mat[i][j];
        colNo++;
        if (colNo == c) {
          colNo = 0;
          rowNo++;
        }
      }
    }
    return newMat;
  }
}