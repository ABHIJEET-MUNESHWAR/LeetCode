package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    30/08/23,
 * Time:    1:05 pm
 * https://leetcode.com/problems/faulty-keyboard/
 */
public class FaultyKeyboard {
  public static void main(String[] args) {
    FaultyKeyboard faultyKeyboard = new FaultyKeyboard();
    String s = "qskyviiiii";
    System.out.println(faultyKeyboard.faultyKeyboard(s));
  }

  private String faultyKeyboard(String s) {
    int size = s.length();
    StringBuilder sb = new StringBuilder();
    for (char ch : s.toCharArray()) {
      if (ch == 'i') {
        sb.reverse();
      } else {
        sb.append(ch);
      }
    }
    return sb.toString();
  }
}