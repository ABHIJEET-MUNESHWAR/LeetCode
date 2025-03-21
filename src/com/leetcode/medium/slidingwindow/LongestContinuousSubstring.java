package com.leetcode.medium.slidingwindow;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    30/05/24,
 * Time:    4:45 pm
 * 2414. Length of the Longest Alphabetical Continuous Substring
 * https://leetcode.com/problems/length-of-the-longest-alphabetical-continuous-substring/description/
 */
public class LongestContinuousSubstring {
  public static void main(String[] args) {
    LongestContinuousSubstring longestContinuousSubstring = new LongestContinuousSubstring();
    String s = "abacaba";
    System.out.println(longestContinuousSubstring.longestContinuous(s));
    System.out.println(longestContinuousSubstring.longestContinuousSubstringSlidingWindow(s));
  }

  private int longestContinuous(String s) {
    int size = s.length();
    int maxLength = 1;
    int currentMax = 1;
    char[] chars = s.toCharArray();
    for (int i = 1; i < size; i++) {
      if (chars[i] - chars[i - 1] == 1) {
        currentMax++;
      } else {
        currentMax = 1;
      }
      maxLength = Math.max(maxLength, currentMax);
    }
    return maxLength;
  }

  private int longestContinuousSubstringSlidingWindow(String s) {
    int size = s.length();
    int maxLength = 0;
    int currentLength = 0;
    int left = 0;
    int right = 0;
    while (right < size) {
      while ((right + 1 < size) && ((int) (s.charAt(right) + 1) == (int) (s.charAt(right + 1)))) {
        right++;
      }
      currentLength = right - left + 1;
      maxLength = Math.max(maxLength, currentLength);
      right++;
      left = right;
    }
    return maxLength;
  }
}