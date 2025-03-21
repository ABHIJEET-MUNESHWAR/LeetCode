package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    17/09/23,
 * Time:    4:53 pm
 * https://leetcode.com/problems/determine-if-string-halves-are-alike/description/
 */
public class HalvesVowelsAreAlike {
  public static void main(String[] args) {
    HalvesVowelsAreAlike halvesVowelsAreAlike = new HalvesVowelsAreAlike();
    System.out.println(halvesVowelsAreAlike.halvesVowelsAreAlike("AbCdEfGh"));
  }

  private boolean halvesVowelsAreAlike(String s) {
    int leftVowelsCount = 0;
    int rightVowelsCount = 0;
    int size = s.length();
    String vowelsLowerCase = "aeiou";
    String vowelsUpperCase = "AEIOU";
    for (int i = 0, j = size - 1; i < j; i++, j--) {
      if ((vowelsLowerCase.indexOf(s.charAt(i), 0) != -1) ||
          (vowelsUpperCase.indexOf(s.charAt(i), 0) != -1)) {
        leftVowelsCount++;
      }
      if ((vowelsLowerCase.indexOf(s.charAt(j), 0) != -1) ||
          (vowelsUpperCase.indexOf(s.charAt(j), 0) != -1)) {
        rightVowelsCount++;
      }
    }
    return leftVowelsCount == rightVowelsCount;
  }
}