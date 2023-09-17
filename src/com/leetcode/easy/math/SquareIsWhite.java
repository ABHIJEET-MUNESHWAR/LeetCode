package com.leetcode.easy.math;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    16/09/23,
 * Time:    10:56 pm
 * https://leetcode.com/problems/determine-color-of-a-chessboard-square/description/
 */
public class SquareIsWhite {
  public static void main(String[] args) {
    SquareIsWhite squareIsWhite = new SquareIsWhite();
    System.out.println(squareIsWhite.squareIsWhite("c7"));
  }

  private boolean squareIsWhite(String coordinates) {
    int x = coordinates.charAt(1) - 'a';
    int y = coordinates.charAt(0) - '0';
    if (x % 2 == 0) {
      if (y % 2 == 1) {
        return false;
      } else {
        return true;
      }
    } else {
      if (y % 2 == 1) {
        return true;
      } else {
        return false;
      }
    }
  }
}