package com.leetcode.medium.map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    17/05/24,
 * Time:    10:30 am
 * 567. Permutation in String
 * https://leetcode.com/problems/permutation-in-string/description/
 */
public class PermutationInString {
  public static void main(String[] args) {
    PermutationInString permutationInString = new PermutationInString();
    String s1 = "ab", s2 = "eidbaooo";
    System.out.println(permutationInString.permutationInString(s1, s2));
  }

  private boolean permutationInString(String s1, String s2) {
    int[] count = new int[26];
    int size1 = s1.length();
    int size2 = s2.length();
    if (size2 < size1) {
      return false;
    }
    for (int i = 0; i < size1; i++) {
      count[s1.charAt(i) - 'a']++;
      count[s2.charAt(i) - 'a']--;
    }
    if (isAllZero(count)) {
      return true;
    }
    for (int i = size1; i < size2; i++) {
      count[s2.charAt(i) - 'a']--;
      count[s2.charAt(i - size1) - 'a']++;
      if (isAllZero(count)) {
        return true;
      }
    }

    return false;
  }

  private boolean isAllZero(int[] count) {
    for (int i = 0; i < 26; i++) {
      if (count[i] != 0) {
        return false;
      }
    }
    return true;
  }
}