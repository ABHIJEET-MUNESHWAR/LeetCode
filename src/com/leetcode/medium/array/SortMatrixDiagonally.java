package com.leetcode.medium.array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    28/08/22, Time:    7:49 AM
 * https://leetcode.com/problems/sort-the-matrix-diagonally/discuss/489749/JavaPython-Straight-Forward
 */
public class SortMatrixDiagonally {

  public static void main(String[] args) {
    SortMatrixDiagonally sortMatrixDiagonally = new SortMatrixDiagonally();
    int[][] matrix = {{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}};
    sortMatrixDiagonally.printMatrix(matrix);
    matrix = sortMatrixDiagonally.diagonalSort(matrix);
    sortMatrixDiagonally.printMatrix(matrix);
  }

  private void printMatrix(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  private int[][] diagonalSort(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    Map<Integer, PriorityQueue<Integer>> queueMap = new HashMap<>();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        queueMap.putIfAbsent((i - j), new PriorityQueue<>());
        queueMap.get((i - j)).add(matrix[i][j]);
      }
    }
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrix[i][j] = queueMap.get((i - j)).poll();
      }
    }
    return matrix;
  }
}