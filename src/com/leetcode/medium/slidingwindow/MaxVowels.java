package com.leetcode.medium.slidingwindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    29/05/24,
 * Time:    10:43 pm
 * 1456. Maximum Number of Vowels in a Substring of Given Length
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
 */
public class MaxVowels {
  public static void main(String[] args) {
    MaxVowels maxVowels = new MaxVowels();
    String s = "abciiidef";
    int k = 3;
    System.out.println(maxVowels.maxVowels(s, k));
  }

  private int maxVowels(String s, int k) {
    int size = s.length();
    int left = 0, right = 0;
    int maxVowelsLength = 0;
    int currentVowels = 0;
    while (right < size) {
      if (isVowel(s.charAt(right))) {
        currentVowels++;
      }
      if ((right - left + 1) == k) {
        maxVowelsLength = Math.max(maxVowelsLength, currentVowels);
        if (isVowel(s.charAt(left))) {
          currentVowels--;
        }
        left++;
      }
      right++;
    }
    return maxVowelsLength;
  }

  private boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
  }
}