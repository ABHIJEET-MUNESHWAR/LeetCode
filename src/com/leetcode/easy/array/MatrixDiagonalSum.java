package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    08/05/23, Time:    11:05 am
 * https://leetcode.com/problems/matrix-diagonal-sum/
 */
public class MatrixDiagonalSum {

  public static void main(String[] args) {
    MatrixDiagonalSum matrixDiagonalSum = new MatrixDiagonalSum();
    int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    System.out.println(matrixDiagonalSum.diagonalSum(mat));
  }

  private int diagonalSum(int[][] mat) {
    int row = mat[0].length;
    int col = mat.length;
    int sum = 0;
    for (int i = 0; i < row; i++) {
      sum += mat[i][i];
      sum += mat[row - i - 1][i];
    }
    sum = (row % 2) == 0 ? sum : sum-mat[row / 2][col / 2];
    return sum;
  }
}