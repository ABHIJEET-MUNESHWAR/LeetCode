package com.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    16/05/24,
 * Time:    8:21 am
 * 424. Longest Repeating Character Replacement
 * https://leetcode.com/problems/longest-repeating-character-replacement/description/
 */
public class CharacterReplacement {
  public static void main(String[] args) {
    CharacterReplacement characterReplacement = new CharacterReplacement();
    String s = "AABABBA";
    int k = 1;
    System.out.println(characterReplacement.characterReplacement(s, k));
  }

  private int characterReplacement(String s, int k) {
    int maxWindowLength = 0;
    int left = 0;
    int right = 0;
    int size = s.length();
    int maxFrequency = 0;
    int[] counts = new int[26];
    while (right < size) {
      counts[s.charAt(right) - 'A']++;
      maxFrequency = Math.max(maxFrequency, counts[s.charAt(right) - 'A']);
      if (((right - left + 1) - maxFrequency) > k) {
        counts[s.charAt(left) - 'A']--;
        left++;
      } else {
        maxWindowLength = Math.max(maxWindowLength, right - left + 1);
      }
      right++;
    }
    return maxWindowLength;
  }
}