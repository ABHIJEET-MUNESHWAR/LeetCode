package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    12/04/23, Time:    11:48 am
 * https://leetcode.com/problems/count-the-number-of-consistent-strings/
 */
public class CountConsistentStrings {

  public static void main(String[] args) {
    CountConsistentStrings countConsistentStrings = new CountConsistentStrings();
    String allowed = "ab";
    String[] words = new String[]{"ad", "bd", "aaab", "baa", "badab"};
    System.out.println(countConsistentStrings.countConsistentStrings(allowed, words));
  }

  private int countConsistentStrings(String allowed, String[] words) {
    int count = 0;
    for (String word : words) {
      char[] chars = word.toCharArray();
      boolean isAllowed = true;
      for (char ch : chars) {
        if (!allowed.contains(ch + "")) {
          isAllowed = false;
          break;
        }
      }
      if (isAllowed) {
        count++;
      }
    }
    return count;
  }
}