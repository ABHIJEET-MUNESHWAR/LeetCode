package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    17/09/22, Time:    1:15 PM
 */
public class IsSubsequence {

  public static void main(String[] args) {
    IsSubsequence isSubsequence = new IsSubsequence();
    String s = "axc", t = "ahbgdc";
    System.out.println(isSubsequence(s, t));
  }

  private static boolean isSubsequence(String s, String t) {
    int index = -1;
    for (char c : s.toCharArray()) {
      index = t.indexOf(c, index + 1);
      if (index == -1) {
        return false;
      }
    }
    return true;
  }
}