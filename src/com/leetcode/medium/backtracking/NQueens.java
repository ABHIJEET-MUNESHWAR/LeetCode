package com.leetcode.medium.backtracking;

import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    28/06/24,
 * Time:    4:22 pm
 * 51. N-Queens
 * https://leetcode.com/problems/n-queens/description/
 */
public class NQueens {
  public static void main(String[] args) {
    NQueens nQueens = new NQueens();
    int n = 4;
    ListUtils.printStringLists(nQueens.solveNQueens(n));
    System.out.println();
    ListUtils.printStringLists(nQueens.solveNQueensOptimised(n));
  }

  List<List<String>> result = new ArrayList<>();

  private List<List<String>> solveNQueensOptimised(int n) {
    if (n == 0) {
      return result;
    }
    List<String> board = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      StringBuilder row = new StringBuilder();
      for (int j = 0; j < n; j++) {
        row.append(".");
      }
      board.add(row.toString());
    }
    int startRow = 0;
    Set<Integer> cols = new HashSet<>();
    Set<Integer> diagonals = new HashSet<>();
    Set<Integer> antiDiagonals = new HashSet<>();
    solveOptimised(board, startRow, cols, diagonals, antiDiagonals);
    return result;
  }

  private void solveOptimised(List<String> board, int row, Set<Integer> cols, Set<Integer> diagonals, Set<Integer> antiDiagonals) {
    if (row == board.size()) {
      result.add(new ArrayList<>(board));
      return;
    }
    /*
     * For a square (i, j) : Diagonally (i-j) is constant Anti diagonally (i+j) is
     * constant
     *
     * We can use this to find which square (i, j) has a risk of being attacked
     * by another queen placed already in 'diagonal', or 'anti-diagonal' or
     * 'column'
     */
    for (int col = 0; col < board.size(); col++) {
      int diagonalId = row - col;
      int antiDiagonalId = row + col;
      /*
       * If the col, or diagonal or anti_diagonal are used means one of them has a
       * Queen placed already which can attack, so look for other column
       */
      if (cols.contains(col) || antiDiagonals.contains(antiDiagonalId) || diagonals.contains(diagonalId)) {
        continue;
      }
      cols.add(col);
      diagonals.add(diagonalId);
      antiDiagonals.add(antiDiagonalId);

      StringBuilder newRow = new StringBuilder(board.get(row));
      newRow.setCharAt(col, 'Q');
      board.set(row, newRow.toString());

      solveOptimised(board, row + 1, cols, diagonals, antiDiagonals);

      cols.remove(col);
      antiDiagonals.remove(antiDiagonalId);
      diagonals.remove(diagonalId);

      newRow.setCharAt(col, '.');
      board.set(row, newRow.toString());
    }
  }

  private List<List<String>> solveNQueens(int n) {
    if (n == 0) {
      return result;
    }
    List<String> board = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      StringBuilder row = new StringBuilder();
      for (int j = 0; j < n; j++) {
        row.append(".");
      }
      board.add(row.toString());
    }
    solve(board, 0);
    return result;
  }

  private void solve(List<String> board, int row) {
    if (row == board.size()) {
      result.add(new ArrayList<>(board));
      return;
    }
    // Place one queen at every row and check before placing
    // in every direction where there is a risk of being attacked
    // i.e., up, diagonally because we are placing queens from
    // the top row to the bottom row, so we need to check if we put a queen
    // vertically up in some row or diagonally upwards in same row
    for (int i = 0; i < board.size(); i++) {
      if (isValid(board, row, i)) {
        StringBuilder newRow = new StringBuilder(board.get(row));
        newRow.setCharAt(i, 'Q');
        board.set(row, newRow.toString());

        solve(board, row + 1);

        newRow.setCharAt(i, '.');
        board.set(row, newRow.toString());
      }
    }
  }

  private boolean isValid(List<String> board, int row, int col) {
    // Look up
    for (int i = row; i >= 0; i--) {
      if (board.get(i).charAt(col) == 'Q') {
        return false;
      }
    }
    // Check left diagonal upwards
    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
      if (board.get(i).charAt(j) == 'Q') {
        return false;
      }
    }
    // Check right diagonal upwards
    for (int i = row, j = col; i >= 0 && j < board.size(); i--, j++) {
      if (board.get(i).charAt(j) == 'Q') {
        return false;
      }
    }
    return true;
  }
}