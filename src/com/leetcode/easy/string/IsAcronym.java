package com.leetcode.easy.string;

import java.util.Arrays;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    30/08/23,
 * Time:    12:21 pm
 * https://leetcode.com/problems/check-if-a-string-is-an-acronym-of-words/
 */
public class IsAcronym {
  public static void main(String[] args) {
    IsAcronym isAcronym = new IsAcronym();
    List<String> words = Arrays.asList("never", "gonna", "give", "up", "on", "you");
    String s = "ngguoy";
    System.out.println(isAcronym.isAcronym(words, s));
  }

  private boolean isAcronym(List<String> words, String s) {
    int size = words.size();
    String acronum = "";
    for (int i = 0; i < size; i++) {
      acronum += words.get(i).charAt(0);
    }
    return acronum.equals(s);
  }
}