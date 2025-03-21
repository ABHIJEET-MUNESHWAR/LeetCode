package com.leetcode.easy.string;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    03/07/22, Time:    6:23 PM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/
 */
public class ReverseString {

  public static void main(String[] args) {
    char[] str = new char[]{'h', 'e', 'l', 'l', 'o'};
    System.out.println("String before reversal:" + Arrays.toString(str));
    ReverseString reverseString = new ReverseString();
    reverseString.reverseString(str);
    System.out.println("String after reversal:" + Arrays.toString(str));
  }

  private void reverseString(char[] str) {
    int len = str.length;
    for (int i = 0, j = len - 1; i < j; i++, j--) {
      char temp = str[i];
      str[i] = str[j];
      str[j] = temp;
    }
  }

}