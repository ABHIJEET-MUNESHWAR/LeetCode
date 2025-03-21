package com.leetcode.easy.bit;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    27/08/22, Time:    10:14 PM
 * https://leetcode.com/problems/add-binary/
 */
public class AddBinary {

  public static void main(String[] args) {
    AddBinary addBinary = new AddBinary();
    System.out.println(addBinary.addBinary("11", "1"));
  }

  private String addBinary(String a, String b) {
    int i = a.length() - 1;
    int j = b.length() - 1;
    int carry = 0;
    StringBuilder stringBuilder = new StringBuilder();
    while (i >= 0 || j >= 0) {
      int sum = carry;
      if (i >= 0) {
        sum += a.charAt(i--) - '0';
      }
      if (j >= 0) {
        sum += b.charAt(j--) - '0';
      }
      stringBuilder.append(sum % 2);
      carry = sum / 2;
    }
    if (carry != 0) {
      stringBuilder.append(carry);
    }
    return stringBuilder.reverse().toString();
  }
}