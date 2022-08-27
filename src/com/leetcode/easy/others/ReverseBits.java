package com.leetcode.easy.others;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    27/08/22, Time:    5:49 PM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/648/
 */
public class ReverseBits {

  public static void main(String[] args) {
    ReverseBits reverseBits = new ReverseBits();
    System.out.println(reverseBits.getReversedBits(1));
  }

  private int getReversedBits(int n) {
    int result = 0;
    for (int i = 0; i < 32; i++) {
      result = result << 1;
      if ((n & 1) == 1) {
        result++;
      }
      n = n >> 1;
    }
    return result;
  }
}