package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    17/09/22, Time:    12:48 PM
 * https://leetcode.com/problems/find-the-difference/
 */
public class FindDifference {

  public static void main(String[] args) {
    FindDifference findDifference = new FindDifference();
    String s = "";
    String t = "y";
    System.out.println(findDifference.findTheDifference(s, t));
  }

  private char findTheDifference(String s, String t) {
    int len = s.length();
    int ch = t.charAt(len);
    for (int i = 0; i < len; i++) {
      ch -= s.charAt(i);
      ch += t.charAt(i);
    }
    return (char) ch;
  }
}