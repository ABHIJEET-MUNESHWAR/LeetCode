package com.leetcode.medium.graph;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    05/06/24,
 * Time:    4:48 pm
 * 130. Surrounded Regions
 * https://leetcode.com/problems/surrounded-regions/description/
 */
public class SurroundedRegions {
  public static void main(String[] args) {
    SurroundedRegions surroundedRegions = new SurroundedRegions();
    //char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
    char[][] board = {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}};
    surroundedRegions.solve(board);
  }

  private void solve(char[][] board) {
    int m = board.length;
    int n = board[0].length;
    int[][] visited = new int[m][n];
    // traverse first row and last row
    for (int i = 0; i < m; i++) {
      // check for unvisited Os in the boundary rows

      // first row
      if (visited[0][i] == 0 && board[0][i] == 'O') {
        dfs(board, visited, 0, i, m, n);
      }

      // last row
      if (visited[n - 1][i] == 0 && board[n - 1][i] == 'O') {
        dfs(board, visited, n - 1, i, m, n);
      }
    }
    // traverse first column and last column
    for (int i = 0; i < n; i++) {
      // check for unvisited Os in the boundary columns

      // first column
      if (visited[i][0] == 0 && board[i][0] == 'O') {
        dfs(board, visited, i, 0, m, n);
      }

      // last column
      if (visited[i][m - 1] == 0 && board[i][m - 1] == 'O') {
        dfs(board, visited, i, m - 1, m, n);
      }
    }

    // if unvisited O then convert to X
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (visited[i][j] == 0 && board[i][j] == 'O') {
          board[i][j] = 'X';
        }
      }
    }
  }

  private void dfs(char[][] board, int[][] visited, int row, int col, int m, int n) {
    visited[row][col] = 1;
    if (row >= 0 && col >= 0 && row < m && col < n && visited[row][col] == 0 && board[row][col] == 'O') {
      dfs(board, visited, row - 1, col, m, n);
      dfs(board, visited, row + 1, col, m, n);
      dfs(board, visited, row, col - 1, m, n);
      dfs(board, visited, row, col + 1, m, n);
    }
  }
}