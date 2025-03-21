package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    04/07/22, Time:    10:07 AM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/884/
 */
public class StringToInteger {

  public static void main(String[] args) {
    StringToInteger stringToInteger = new StringToInteger();
//    String s = "42";
    String s = "   ";
//    String s = "   -42";
//    String s = "4193 with words";
//    String s = "words and 987";
//    String s = "+-12";
    System.out.println(stringToInteger.myAtoi(s));
  }

  private int myAtoi(String s) {
    int len = s.length();
    if (len == 0) {
      return 0;
    }
    int num = 0;
    boolean isPositive = true;
    int i = 0;
    while (i < len && s.charAt(i) == ' ') {
      i++;
    }
    if (i == len) {
      return 0;
    }
    if (s.charAt(i) == '+' || s.charAt(i) == '-') {
      isPositive = s.charAt(i) == '+';
      i++;
    }
    while (i < len) {
      int digit = s.charAt(i) - '0';
      if (digit < 0 || digit > 9) {
        break;
      }
      if (Integer.MAX_VALUE / 10 < num
          || Integer.MAX_VALUE / 10 == num && Integer.MAX_VALUE % 10 < digit) {
        return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }
      num = num * 10 + digit;
      i++;
    }
    if (!isPositive) {
      num = num * -1;
    }
    return num;
  }

}