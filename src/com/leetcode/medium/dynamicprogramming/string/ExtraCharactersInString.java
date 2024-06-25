package com.leetcode.medium.dynamicprogramming.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    25/06/24,
 * Time:    10:39 am
 * 2707. Extra Characters in a String
 * https://leetcode.com/problems/extra-characters-in-a-string/description/?envType=daily-question&envId=2023-09-02
 */
public class ExtraCharactersInString {
  public static void main(String[] args) {
    ExtraCharactersInString extraCharactersInString = new ExtraCharactersInString();
    String s = "leetscode";
    String[] dictionary = {"leet", "code", "leetcode"};
    System.out.println(extraCharactersInString.minExtraCharRecursion(s, dictionary));
    System.out.println(extraCharactersInString.minExtraCharRecursionMemoization(s, dictionary));
  }

  int[] dp;

  private int minExtraCharRecursionMemoization(String s, String[] dictionary) {
    Set<String> set = new HashSet<>();
    for (String d : dictionary) {
      set.add(d);
    }
    dp = new int[s.length() + 1];
    Arrays.fill(dp, -1);
    return solveRecursionMemoization(s, set, 0);
  }

  private int solveRecursionMemoization(String s, Set<String> set, int index) {
    if (index >= s.length()) {
      return 0;
    }
    if (dp[index] != -1) {
      return dp[index];
    }
    int minChars = s.length();
    for (int i = index; i < s.length(); i++) {
      String currentSubString = s.substring(index, i + 1);
      if (set.contains(currentSubString)) {
        minChars = Math.min(minChars, solveRecursionMemoization(s, set, i + 1));
      } else {
        minChars = Math.min(minChars, currentSubString.length() + solveRecursionMemoization(s, set, i + 1));
      }
    }
    return dp[index] = minChars;
  }

  private int minExtraCharRecursion(String s, String[] dictionary) {
    Set<String> set = new HashSet<>();
    for (String d : dictionary) {
      set.add(d);
    }
    return solveRecursion(s, set, 0);
  }

  private int solveRecursion(String s, Set<String> set, int index) {
    if (index >= s.length()) {
      return 0;
    }
    int minChars = s.length();
    for (int i = index; i < s.length(); i++) {
      String currentSubString = s.substring(index, i + 1);
      if (set.contains(currentSubString)) {
        minChars = Math.min(minChars, solveRecursion(s, set, i + 1));
      } else {
        minChars = Math.min(minChars, currentSubString.length() + solveRecursion(s, set, i + 1));
      }
    }
    return minChars;
  }
}