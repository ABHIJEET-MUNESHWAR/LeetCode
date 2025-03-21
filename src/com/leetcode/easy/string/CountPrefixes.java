package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    14/10/23,
 * Time:    11:57am
 * https://leetcode.com/problems/count-prefixes-of-a-given-string/
 */
public class CountPrefixes {
  public static void main(String[] args) {
    CountPrefixes countPrefixes = new CountPrefixes();
    String[] words = {"a", "b", "c", "ab", "bc", "abc"};
    String s = "abc";
    System.out.println(countPrefixes.countPrefixes(words, s));
  }

  private int countPrefixes(String[] words, String s) {
    int count = 0;
    for (String word : words) {
      if (s.startsWith(word)) {
        count++;
      }
    }
    return count;
  }
}