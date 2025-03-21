package com.leetcode.medium.string;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    09/05/24,
 * Time:    3:52 pm
 * 2785. Sort Vowels in a String
 * https://leetcode.com/problems/sort-vowels-in-a-string/description/
 */
public class SortVowels {
  public static void main(String[] args) {
    SortVowels sortVowels = new SortVowels();
    String s = "lEetcOde";
    System.out.println(sortVowels.sortVowels(s));
  }

  private String sortVowels(String s) {
    int size = s.length();
    int vowelCount = 0;
    String vowels = "aeiouAEIOU";
    char[] result = s.toCharArray();
    for (int i = 0; i < size; i++) {
      char c = s.charAt(i);
      if (vowels.contains(String.valueOf(c))) {
        vowelCount++;
      }
    }
    int[] vowelsArray = new int[vowelCount];
    for (int i = 0, j = 0; i < size; i++) {
      char c = s.charAt(i);
      if (vowels.contains(String.valueOf(c))) {
        vowelsArray[j++] = (int) c;
      }
    }
    Arrays.sort(vowelsArray);
    for (int i = 0, j = 0; i < size; i++) {
      char c = s.charAt(i);
      if (vowels.contains(String.valueOf(c))) {
        result[i] = (char) vowelsArray[j];
        j++;
      } else {
        result[i] = c;
      }
    }
    return new String(result);
  }
}