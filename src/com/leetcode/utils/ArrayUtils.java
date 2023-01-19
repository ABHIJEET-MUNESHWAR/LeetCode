package com.leetcode.utils;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    24/11/22, Time:    9:31 PM
 */
public class ArrayUtils {

  public static void printArray(String[] arr) {
    int size = arr.length;
    for (int i = 0; i < size; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void printArray(int[] arr) {
    int size = arr.length;
    for (int i = 0; i < size; i++) {
      System.out.println(arr[i]);
    }
  }
  public static void printMatrix(int[][] matrix) {
    int row=matrix.length;
    int col = matrix[0].length;
    for (int i = 0; i < row; i++) {
      for(int j=0; j<col; j++){
        System.out.println(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}