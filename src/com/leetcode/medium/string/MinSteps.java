package com.leetcode.medium.string;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    08/05/24,
 * Time:    8:30 pm
 * 1347. Minimum Number of Steps to Make Two Strings Anagram
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/description/
 */
public class MinSteps {
  public static void main(String[] args) {
    MinSteps minSteps = new MinSteps();
    String s = "leetcode", t = "practice";
    System.out.println(minSteps.minSteps(s, t));
  }

  private int minSteps(String s, String t) {
    int diffCount = 0;
    int[] countMap = new int[26];
    for (char c : s.toCharArray()) {
      countMap[c - 'a']++;
    }
    for (char c : t.toCharArray()) {
      countMap[c - 'a']--;
    }
    for (int i = 0; i < 26; i++) {
      if (countMap[i] != 0) {
        diffCount += Math.abs(countMap[i]);
      }
    }
    return diffCount / 2;
  }
}