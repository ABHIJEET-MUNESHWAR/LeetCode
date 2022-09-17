package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    17/09/22, Time:    11:06 PM
 * https://leetcode.com/problems/number-of-segments-in-a-string/
 */
public class CountSegments {

  public static void main(String[] args) {
    CountSegments countSegments = new CountSegments();
    System.out.println(countSegments.countSegments("Hello, my name is John"));
  }

  private int countSegments(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int segmentsCount = 0;
    int size = s.length();
    for (int i = 0; i < size; i++) {
      if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i-1) == ' ')) {
        segmentsCount++;
      }
    }
    return segmentsCount;
  }
}