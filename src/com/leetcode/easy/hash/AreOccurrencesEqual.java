package com.leetcode.easy.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    23/09/23,
 * Time:    11:39 pm
 * https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/
 */
public class AreOccurrencesEqual {
  public static void main(String[] args) {
    AreOccurrencesEqual areOccurrencesEqual = new AreOccurrencesEqual();
    System.out.println(areOccurrencesEqual.areOccurrencesEqual("aaabb"));
  }

  private boolean areOccurrencesEqual(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int size = s.length();
    for (int i = 0; i < size; i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    }
    int count = 0;
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      if (count == 0) {
        count = entry.getValue();
      }
      if (count != entry.getValue()) {
        return false;
      }
    }
    return true;
  }
}