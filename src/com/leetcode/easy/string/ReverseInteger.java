package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    03/07/22, Time:    6:45 PM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/
 */
public class ReverseInteger {

  public static void main(String[] args) {
    ReverseInteger reverseInteger = new ReverseInteger();
    int x = -120;
    System.out.println("Number before reversal: " + x);
    System.out.println("Number after reversal: " + reverseInteger.reverseInteger(x));
  }

  private int reverseInteger(int x) {
    int reverseNum = 0;
    int prevNum = 0;
    while (x != 0) {
      prevNum = reverseNum;
      reverseNum = reverseNum * 10 + x % 10;
      if ((reverseNum - x % 10) / 10 != prevNum) {
        return 0;
      }
      x = x / 10;
    }
    return reverseNum;
  }
}