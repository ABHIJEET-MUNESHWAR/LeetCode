package com.leetcode.easy.set;

import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/10/23,
 * Time:    7:23pm
 */
public class MinimizedStringLength {
  public static void main(String[] args) {
    MinimizedStringLength minimizedStringLength = new MinimizedStringLength();
    System.out.println(minimizedStringLength.minimizedStringLength("dddaaa"));
    System.out.println(minimizedStringLength.minimizedStringLength2("dddaaa"));
  }

  private int minimizedStringLength2(String s) {
    return (int) s.chars().distinct().count();
  }

  private int minimizedStringLength(String s) {
    Set<Character> set = new HashSet<>();
    for (char ch : s.toCharArray()) {
      set.add(ch);
    }
    return set.size();
  }
}