package com.leetcode.medium.string;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    09/06/24,
 * Time:    9:16 pm
 * 1910. Remove All Occurrences of a Substring
 * https://leetcode.com/problems/remove-all-occurrences-of-a-substring/description/
 */
public class RemoveOccurrences {
  public static void main(String[] args) {
    RemoveOccurrences removeOccurrences = new RemoveOccurrences();
    String s = "daabcbaabcbc", part = "abc";
    System.out.println(removeOccurrences.removeOccurrences(s, part));
  }

  private String removeOccurrences(String s, String part) {
    StringBuilder build = new StringBuilder();
    int stringLength = s.length();
    int partLength = part.length();
    for (int i = 0; i < stringLength; i++) {
      build.append(s.charAt(i));
      int startIndex = build.length() - partLength;
      if (build.length() >= partLength && build.substring(startIndex).equals(part)) {
        int endIndex = build.length();
        build.delete(startIndex, endIndex);
      }
    }
    return build.toString();
  }
}