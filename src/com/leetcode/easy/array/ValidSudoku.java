package com.leetcode.easy.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    24/06/22, Time:    7:52 AM
 * 36. Valid Sudoku
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/769/
 */
public class ValidSudoku {

  public static void main(String[] args) {
    ValidSudoku validSudoku = new ValidSudoku();
    /*char[][] board = new char[][]{
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };*/
    char[][] board = new char[][] {
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
    System.out.println(validSudoku.isValidSudoku(board) ? "Yes" : "No");
    System.out.println(validSudoku.isValidSudokuOptimised(board) ? "Yes" : "No");
    //System.out.println(validSudoku.isValidSudoku2(board) ? "Yes" : "No");
  }

  private boolean isValidSudokuOptimised(char[][] board) {
    Set<String> seen = new HashSet<>();
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char number = board[i][j];
        if (number != '.') {
          if (!seen.add(number + " in row " + i)
              || !seen.add(number + " in column " + j)
              || !seen.add(number + " in block " + i / 3 + "-" + j / 3)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  private boolean isValidSudoku(char[][] board) {
    boolean isValidSudoku = true;
    for (int i = 0; i < 9; i++) {
      Set<Integer> set = new HashSet<>();
      for (int j = 1; j < 10; j++) {
        set.add(j);
      }
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.') {
          int num = Character.getNumericValue(board[i][j]);
          if (set.contains(num)) {
            set.remove(num);
          } else {
            return false;
          }
        }
      }
    }
    for (int i = 0; i < 9; i++) {
      Set<Integer> set = new HashSet<>();
      for (int j = 1; j < 10; j++) {
        set.add(j);
      }
      for (int j = 0; j < 9; j++) {
        if (board[j][i] != '.') {
          int num = Character.getNumericValue(board[j][i]);
          if (set.contains(num)) {
            set.remove(num);
          } else {
            return false;
          }
        }
      }
    }
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        int startRow = i * 3;
        int startCol = j * 3;
        for (int m = 1; m < 10; m++) {
          set.add(m);
        }
        for (int k = startRow; k < startRow + 3; k++) {
          for (int l = startCol; l < startCol + 3; l++) {
            if (board[k][l] != '.') {
              int num = Character.getNumericValue(board[k][l]);
              if (set.contains(num)) {
                set.remove(num);
              } else {
                return false;
              }
            }
          }
        }
        set = new HashSet<>();
      }
    }
    return isValidSudoku;
  }

  public boolean isValidSudoku2(char[][] board) {
    int n = board.length;
    Set<Integer>[] rows = new Set[n];
    Set<Integer>[] cols = new Set[n];
    Set<Integer>[] blocks = new Set[n];

    for (int i = 0; i < n; i++) {
      rows[i] = new HashSet<Integer>();
      cols[i] = new HashSet<Integer>();
      blocks[i] = new HashSet<Integer>();
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {

        if (board[i][j] == '.') {
          continue;
        }
        int k = 3 * (i / 3) + (j / 3);

        int num = board[i][j] - '0';
        if (rows[i].contains(num)) {
          return false;
        }
        if (cols[j].contains(num)) {
          return false;
        }
        if (blocks[k].contains(num)) {
          return false;
        }

        rows[i].add(num);
        cols[j].add(num);
        blocks[k].add(num);
      }
    }
    return true;
  }
}