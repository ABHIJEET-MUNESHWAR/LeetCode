package com.leetcode.easy.string;

import java.util.regex.Pattern;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    13/03/24,
 * Time:    3:20 pm
 * https://leetcode.com/problems/maximum-value-of-a-string-in-an-array/description/
 */
public class MaximumValue {
  public static void main(String[] args) {
    MaximumValue maximumValue = new MaximumValue();
    String[] strs = {"alic3", "bob", "3", "4", "00000"};
    System.out.println(maximumValue.maximumValue(strs));
  }

  private int maximumValue(String[] strs) {
    int max = 0;
    for (String str : strs) {
      max = Math.max(max, isNumeric(str));
    }
    return max;
  }

  private int isNumeric(String str) {
    int size = str.length();
    for (int i = 0; i < size; i++) {
      if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
        return size;
      }
    }
    return Integer.parseInt(str);
  }
}