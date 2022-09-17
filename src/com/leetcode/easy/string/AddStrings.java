package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    17/09/22, Time:    8:59 PM
 * https://leetcode.com/problems/add-strings/
 */
public class AddStrings {

  public static void main(String[] args) {
    AddStrings addStrings = new AddStrings();
    String num1 = "0", num2 = "0";
    System.out.println(addStrings.addStrings(num1, num2));
  }

  private String addStrings(String num1, String num2) {
    int len1 = num1.length();
    int len2 = num2.length();
    int carry = 0;
    StringBuilder sb = new StringBuilder();
    for (int i = len1 - 1, j = len2 - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
      int x = i < 0 ? 0 : num1.charAt(i) - '0';
      int y = j < 0 ? 0 : num2.charAt(j) - '0';
      sb.append((x + y + carry) % 10);
      carry = (x + y + carry) / 10;
    }
    return sb.reverse().toString();
  }
}