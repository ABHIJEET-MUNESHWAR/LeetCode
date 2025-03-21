package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    29/05/23,
 * Time:    11:32 am
 * https://leetcode.com/problems/maximum-69-number/
 */
public class Maximum69Number {
  public static void main(String[] args) {
    Maximum69Number maximum69Number = new Maximum69Number();
    System.out.println(maximum69Number.maximum69Number(9669));
  }

  private int maximum69Number(int num) {
    String numString = Integer.toString(num);
    numString = numString.replaceFirst("6", "9");
    return Integer.valueOf(numString);
  }
}