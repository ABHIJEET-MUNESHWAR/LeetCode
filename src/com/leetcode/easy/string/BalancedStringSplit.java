package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    16/02/23, Time:    3:06 pm
 * https://leetcode.com/problems/split-a-string-in-balanced-strings/
 */
public class BalancedStringSplit {

  public static void main(String[] args) {
    BalancedStringSplit balancedStringSplit = new BalancedStringSplit();
    System.out.println(balancedStringSplit.balancedStringSplit("RLRRLLRLRL"));
  }

  private int balancedStringSplit(String s) {
    int counter = 0;
    int leftCounter = 0;
    int rightCounter = 0;
    for (char ch : s.toCharArray()) {
      if (ch == 'L') {
        leftCounter++;
      } else {
        rightCounter++;
      }
      if (leftCounter == rightCounter) {
        counter++;
      }
    }
    return counter;
  }
}