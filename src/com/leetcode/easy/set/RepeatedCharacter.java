package com.leetcode.easy.set;

import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    08/10/23,
 * Time:    1:13pm
 */
public class RepeatedCharacter {
  public static void main(String[] args) {
    RepeatedCharacter repeatedCharacter = new RepeatedCharacter();
    System.out.println(repeatedCharacter.repeatedCharacter("abccbaacz"));
  }

  private char repeatedCharacter(String s) {
    Set<Character> set = new HashSet<>();
    for (char ch : s.toCharArray()) {
      if (set.contains(ch)) {
        return ch;
      } else {
        set.add(ch);
      }
    }
    return ' ';
  }
}