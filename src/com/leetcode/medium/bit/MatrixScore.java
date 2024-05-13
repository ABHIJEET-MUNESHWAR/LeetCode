package com.leetcode.medium.bit;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    13/05/24,
 * Time:    10:05 am
 * 861. Score After Flipping Matrix
 * https://leetcode.com/problems/score-after-flipping-matrix/description/?envType=daily-question&envId=2024-05-13
 */
public class MatrixScore {
  public static void main(String[] args) {
    MatrixScore matrixScore = new MatrixScore();
    int[][] grid = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
    System.out.println(matrixScore.matrixScore(grid));
  }

  private int matrixScore(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    int answer = rows * (1 << (cols - 1));
    for (int j = 1; j < cols; j++) {
      int colCount = 0;
      for (int i = 0; i < rows; i++) {
        colCount += grid[i][0] == 0 ? grid[i][j] ^ 1 : grid[i][j];
      }
      if (colCount < (rows - colCount)) {
        answer += (rows - colCount) * (1 << (cols - 1 - j));
      } else {
        answer += (colCount) * (1 << (cols - 1 - j));
      }
    }
    return answer;
  }
}