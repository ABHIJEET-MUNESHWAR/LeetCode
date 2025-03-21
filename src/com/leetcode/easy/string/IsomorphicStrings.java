package com.leetcode.easy.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    31/08/22, Time:    10:38 PM
 * https://leetcode.com/problems/isomorphic-strings/
 */
public class IsomorphicStrings {

  public static void main(String[] args) {
    IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
    String s = "egg";
    String t = "add";
    System.out.println(isomorphicStrings.isIsomorphic(s, t));
    s = "foo";
    t = "bar";
    System.out.println(isomorphicStrings.isIsomorphic(s, t));
    s = "paper";
    t = "title";
    System.out.println(isomorphicStrings.isIsomorphic(s, t));
    s = "badc";
    t = "baba";
    System.out.println(isomorphicStrings.isIsomorphic(s, t));
  }

  private boolean isIsomorphic(String s, String t) {
    int len = s.length();
    Map<Character, Integer> m1 = new HashMap<>();
    Map<Character, Integer> m2 = new HashMap<>();
    for (Integer i = 0; i < len; i++) {
      if (m1.put(s.charAt(i), i) != m2.put(t.charAt(i), i)) {
        return false;
      }
    }
    return true;
  }
}