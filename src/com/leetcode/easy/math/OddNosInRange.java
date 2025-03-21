package com.leetcode.easy.math;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    13/02/23, Time:    8:26 am
 * https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
 */
public class OddNosInRange {

  public static void main(String[] args) {
    OddNosInRange oddNosInRange = new OddNosInRange();
    System.out.println(oddNosInRange.countOdds(3, 7));
  }

  private int countOdds(int low, int high) {
    int nums = high - low + 1;
    if (low % 2 == 1 && high % 2 == 1) {
      return nums / 2 + 1;
    } else {
      return nums / 2;
    }
  }
}