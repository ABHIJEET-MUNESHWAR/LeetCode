package com.leetcode.easy.others;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    27/08/22, Time:    4:58 PM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/565/
 */
public class NoOf1Bits {

  public static void main(String[] args) {
    NoOf1Bits noOf1Bits = new NoOf1Bits();
    System.out.println(noOf1Bits.hammingWeight(00000000000000000000000000001011));
  }

  private int hammingWeight(int num) {
    int count = 0;
    while (num != 0) {
      count += num & 1;
      num = num >>> 1;
    }
    return count;
  }
}