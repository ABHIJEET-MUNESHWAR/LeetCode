package com.leetcode.medium.search;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    20/05/24,
 * Time:    5:03 pm
 * 74. Search a 2D Matrix
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
public class SearchMatrix {
  public static void main(String[] args) {
    SearchMatrix searchMatrix = new SearchMatrix();
    int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
    int target = 3;
    System.out.println(searchMatrix.searchMatrix(matrix, target));
  }

  private boolean searchMatrix(int[][] matrix, int target) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int left = 0;
    int right = rows * cols - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      int row = mid / cols;
      int col = mid % cols;
      if (matrix[row][col] == target) {
        return true;
      } else if (matrix[row][col] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return false;
  }
}