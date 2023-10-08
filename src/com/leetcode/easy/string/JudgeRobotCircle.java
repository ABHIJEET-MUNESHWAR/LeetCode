package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/10/23,
 * Time:    10:53am
 */
public class JudgeRobotCircle {
  public static void main(String[] args) {
    JudgeRobotCircle judgeRobotCircle = new JudgeRobotCircle();
    String moves = "LRUD";
    System.out.println(judgeRobotCircle.judgeRobotCircle(moves));
  }

  private boolean judgeRobotCircle(String moves) {
    int l = 0, r = 0, u = 0, d = 0;
    char[] movesCharArray = moves.toCharArray();
    for (char move : movesCharArray) {
      switch (move) {
        case 'U':
          u++;
          break;
        case 'D':
          d++;
          break;
        case 'L':
          l++;
          break;
        case 'R':
          r++;
          break;
      }
    }
    return (l == r) && (u == d);
  }
}