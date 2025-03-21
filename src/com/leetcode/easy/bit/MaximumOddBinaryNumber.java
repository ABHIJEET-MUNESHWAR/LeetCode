package com.leetcode.easy.bit;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    14/10/23,
 * Time:    4:07pm
 */
public class MaximumOddBinaryNumber {
  public static void main(String[] args) {
    MaximumOddBinaryNumber maximumOddBinaryNumber = new MaximumOddBinaryNumber();
    String s = "0101";
    System.out.println(maximumOddBinaryNumber.maximumOddBinaryNumber(s));
  }

  private String maximumOddBinaryNumber(String s) {
    String ans = "";
    int once = 0;
    int zeros = 0;
    for (char ch : s.toCharArray()) {
      if (ch == '1') {
        once++;
      } else {
        zeros++;
      }
    }
    while (once > 1) {
      ans += "1";
      once--;
    }
    while (zeros > 0) {
      ans += "0";
      zeros--;
    }
    ans += "1";
    return ans;
  }
}