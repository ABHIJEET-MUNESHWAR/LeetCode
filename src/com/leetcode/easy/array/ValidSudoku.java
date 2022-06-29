package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    24/06/22, Time:    7:52 AM
 */
public class ValidSudoku {

  public static void main(String[] args) {
    ValidSudoku validSudoku = new ValidSudoku();
    char[][] board = new char[][]{
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };
    System.out.println(validSudoku.isValidSudoku(board) ? "Yes" : "No");
  }

  private boolean isValidSudoku(char[][] board) {
    boolean isValidSudoku = false;
    return isValidSudoku;
  }
}