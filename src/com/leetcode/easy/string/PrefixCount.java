package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    17/09/23,
 * Time:    7:22 pm
 * https://leetcode.com/problems/counting-words-with-a-given-prefix/
 */
public class PrefixCount {
  public static void main(String[] args) {
    PrefixCount prefixCount = new PrefixCount();
    String[] words = {"pay", "attention", "practice", "attend"};
    String pref = "at";
    System.out.println(prefixCount.prefixCount(words, pref));
  }

  private int prefixCount(String[] words, String pref) {
    int count = 0;
    for (String word : words) {
      if (word.indexOf(pref) == 0) {
        count++;
      }
    }
    return count;
  }
}