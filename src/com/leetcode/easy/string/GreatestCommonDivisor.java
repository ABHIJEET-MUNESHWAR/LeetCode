package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    02/02/23, Time:    10:57 pm
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/description/
 */
public class GreatestCommonDivisor {

  public static void main(String[] args) {
    GreatestCommonDivisor greatestCommonDivisor = new GreatestCommonDivisor();
    System.out.println(greatestCommonDivisor.gcdOfStrings("ABABAB", "ABAB"));
  }

  private String gcdOfStrings(String str1, String str2) {
    if (!(str1 + str2).equals(str2 + str1)) {
      return "";
    }
    int gcd = gcd(str1.length(), str2.length());
    return str2.substring(0, gcd);
  }

  private int gcd(int n1, int n2) {
    if (n2 == 0) {
      return n1;
    }
    return gcd(n2, n1 % n2);
  }
}