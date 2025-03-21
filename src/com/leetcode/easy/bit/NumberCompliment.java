package com.leetcode.easy.bit;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    24/09/22, Time:    7:11 PM
 * https://leetcode.com/problems/number-complement/
 */
public class NumberCompliment {

  public static void main(String[] args) {
    NumberCompliment numberCompliment = new NumberCompliment();
    System.out.println(numberCompliment.findComplement(5));
  }

  private int findComplement(int num) {
    int mask = num;
    mask |= mask >> 1;
    mask |= mask >> 2;
    mask |= mask >> 4;
    mask |= mask >> 8;
    mask |= mask >> 16;
    return num ^ mask;
  }
}