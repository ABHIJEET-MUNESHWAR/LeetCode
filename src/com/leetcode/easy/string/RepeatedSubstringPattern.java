package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    24/09/22, Time:    12:38 PM
 * https://leetcode.com/problems/repeated-substring-pattern/
 */
public class RepeatedSubstringPattern {

  public static void main(String[] args) {
    RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();
    System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("abab"));
  }

  private boolean repeatedSubstringPattern(String str) {
    String s = str + str;
    return s.substring(1, s.length() - 1).contains(str);
  }
}