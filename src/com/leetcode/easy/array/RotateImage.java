package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    30/06/22, Time:    6:36 AM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/770/
 */
public class RotateImage {

  public static void main(String[] args) {
    RotateImage rotateImage = new RotateImage();
    int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    System.out.println("Matrix before rotating.");
    rotateImage.printMatrix(matrix);
    rotateImage.rotate(matrix);
    System.out.println("Matrix after rotating.");
    rotateImage.printMatrix(matrix);
  }

  private void rotate(int[][] matrix) {
    // transpose
    int rows = matrix.length;
    int cols = matrix[0].length;
    for (int i = 0; i < rows; i++) {
      for (int j = i; j < cols; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
    // swap
    for (int i = 0; i < rows; i++) {
      for (int j = 0, k = cols - 1; k > j; j++, k--) {
        int temp = matrix[i][k];
        matrix[i][k] = matrix[i][j];
        matrix[i][j] = temp;
      }
    }
  }

  private void printMatrix(int[][] matrix) {
    int cols = matrix[0].length;
    int rows = matrix.length;
    System.out.println();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }
}