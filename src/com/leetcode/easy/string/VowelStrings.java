package com.leetcode.easy.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/10/23,
 * Time:    9:03pm
 */
public class VowelStrings {
  public static void main(String[] args) {
    VowelStrings vowelStrings = new VowelStrings();
    String[] words = {"hey", "aeo", "mu", "ooo", "artro"};
    int left = 1, right = 4;
    System.out.println(vowelStrings.vowelStrings(words, left, right));
  }

  private int vowelStrings(String[] words, int left, int right) {
    Set<Character> vowels = new HashSet<>();
    vowels.add('a');
    vowels.add('e');
    vowels.add('i');
    vowels.add('o');
    vowels.add('u');
    int count = 0;
    for (int i = left; i <= right; i++) {
      String word = words[i];
      if (vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1))) {
        count++;
      }
    }
    return count;
  }
}