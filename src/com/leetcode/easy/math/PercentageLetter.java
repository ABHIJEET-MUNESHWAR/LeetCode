package com.leetcode.easy.math;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    08/10/23,
 * Time:    11:11am
 */
public class PercentageLetter {
  public static void main(String[] args) {
    PercentageLetter percentageLetter = new PercentageLetter();
    String s = "foobar";
    char letter = 'o';
    System.out.println(percentageLetter.percentageLetter(s, letter));
  }

  private int percentageLetter(String s, char letter) {
    int size = s.length();
    int count = 0;
    for (char ch : s.toCharArray()) {
      if (ch == letter) {
        count++;
      }
    }
    return (count * 100) / size;
  }
}