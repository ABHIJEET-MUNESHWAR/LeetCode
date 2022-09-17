package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    17/09/22, Time:    8:28 PM
 * https://leetcode.com/problems/third-maximum-number/
 */
public class ThirdMax {

  public static void main(String[] args) {
    ThirdMax thirdMax = new ThirdMax();
    int[] nums = new int[]{3, 2, 1};
    System.out.println(thirdMax.thirdMax(nums));
  }

  private int thirdMax(int[] nums) {
    Integer first = null;
    Integer second = null;
    Integer third = null;
    for (Integer i : nums) {
      if (i.equals(first) || i.equals(second) || i.equals(third)) {
        continue;
      }
      if (first == null || first < i) {
        third = second;
        second = first;
        first = i;
      }else if (second == null || second < i) {
        third = second;
        second = i;
      } else if (third == null || third < i) {
        third = i;
      }
    }
    return third == null ? first : third;
  }
}