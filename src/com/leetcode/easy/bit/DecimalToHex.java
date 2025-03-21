package com.leetcode.easy.bit;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    17/09/22, Time:    7:12 PM
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal/
 */
public class DecimalToHex {

  public static void main(String[] args) {
    DecimalToHex decimalToHex = new DecimalToHex();
    System.out.println(decimalToHex.toHex(26));
  }

  private String toHex(int num) {
    if (num == 0) {
      return "0";
    }
    char[] hex = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
        'e', 'f'};
    StringBuilder ans = new StringBuilder();
    int count = 0;
    while (count < 8 && num != 0) {
      ans.append(hex[num & 15]);
      num = num >> 4;
      count++;
    }
    return ans.reverse().toString();
  }
}