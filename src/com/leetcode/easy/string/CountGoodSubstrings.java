package com.leetcode.easy.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    14/10/23,
 * Time:    2:31pm
 * https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/
 */
public class CountGoodSubstrings {
  public static void main(String[] args) {
    CountGoodSubstrings countGoodSubstrings = new CountGoodSubstrings();
    String s = "aababcabc";
    System.out.println(countGoodSubstrings.countGoodSubstrings(s));
  }

  private int countGoodSubstrings(String s) {
    int count = 0;
    int size = s.length();
    for (int i = 2; i < size; i++) {
      if (s.charAt(i - 2) != s.charAt(i - 1) && s.charAt(i - 1) != s.charAt(i) &&
          s.charAt(i - 2) != s.charAt(i)) {
        count++;
      }
    }
    return count;
  }
}