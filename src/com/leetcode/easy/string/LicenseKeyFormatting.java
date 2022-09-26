package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    24/09/22, Time:    7:40 PM
 * https://leetcode.com/problems/license-key-formatting/
 */
public class LicenseKeyFormatting {

  public static void main(String[] args) {
    LicenseKeyFormatting licenseKeyFormatting = new LicenseKeyFormatting();
    String s = "2-4A0r7-4k";
    int k = 4;
    System.out.println(licenseKeyFormatting.licenseKeyFormatting(s, k));
  }

  private String licenseKeyFormatting(String s, int k) {
    s = s.replaceAll("-", "");
    s = s.toUpperCase();
    StringBuilder stringBuilder = new StringBuilder(s);
    int i = stringBuilder.length() - k;
    while (i > 0) {
      stringBuilder.insert(i, "-");
      i -= k;
    }
    return stringBuilder.toString();
  }
}