package com.leetcode.easy.math;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    21/11/22, Time:    8:41 AM
 * https://leetcode.com/problems/base-7/
 */
public class ConvertToBase7 {

  public static void main(String[] args) {
    int num = 100;
    ConvertToBase7 convertToBase7 = new ConvertToBase7();
    System.out.println(convertToBase7.convertToBase7(num));
  }

  private String convertToBase7(int num) {
    if (num == 0) {
      return "0";
    }
    boolean isNegative = false;
    if (num < 0) {
      isNegative = true;
    }
    StringBuilder sb = new StringBuilder();

    while (num != 0) {
      sb.append(Math.abs(num % 7));
      num = num / 7;
    }
    if (isNegative) {
      sb.append("-");
    }
    return sb.reverse().toString();
  }
}