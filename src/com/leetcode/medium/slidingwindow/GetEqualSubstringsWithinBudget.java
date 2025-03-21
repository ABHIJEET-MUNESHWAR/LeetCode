package com.leetcode.medium.slidingwindow;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    28/05/24,
 * Time:    8:16 am
 * 1208. Get Equal Substrings Within Budget
 * https://leetcode.com/problems/get-equal-substrings-within-budget/description/?envType=daily-question&envId=2024-05-28
 */
public class GetEqualSubstringsWithinBudget {
  public static void main(String[] args) {
    GetEqualSubstringsWithinBudget getEqualSubstringsWithinBudget = new GetEqualSubstringsWithinBudget();
    String s = "krrgw", t = "zjxss";
    //String s = "pxezla", t = "loewbi";
    //String s = "abcd", t = "bcdf";
    //String s = "abcd", t = "cdef";
    int maxCost = 19;
    System.out.println(getEqualSubstringsWithinBudget.equalSubstring(s, t, maxCost));
  }

  private int equalSubstring(String s, String t, int maxCost) {
    int maxConversions = 0;
    int size = s.length();
    int i = 0, j = 0;
    int currentCost = 0;
    while (i < size && j < t.length()) {
      currentCost += Math.abs(s.charAt(j) - t.charAt(j));
      while (currentCost > maxCost) {
        currentCost -= Math.abs(s.charAt(i) - t.charAt(i));
        i++;  // Shrink window from left side
      }
      maxConversions = Math.max(maxConversions, j - i + 1);
      j++;    // Expand window
    }
    return maxConversions;
  }
}