package com.leetcode.medium.map;

import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    15/05/24,
 * Time:    9:17 pm
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LengthOfLongestSubstring {
  public static void main(String[] args) {
    LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
    String s = "abcabcbb";
    System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(s));

  }

  private int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int size = s.length();
    Set<Character> set = new HashSet<>();
    int maxLength = 0, i = 0, j = 0;
    while (j < size) {
      if (!set.contains(s.charAt(j))) {
        set.add(s.charAt(j++));
        maxLength = Math.max(maxLength, set.size());
      } else {
        set.remove(s.charAt(i++));
      }
    }
    return maxLength;
  }
}