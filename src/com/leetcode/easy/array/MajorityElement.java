package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    31/08/22, Time:    6:38 PM
 * https://leetcode.com/problems/majority-element/
 */
public class MajorityElement {

  public static void main(String[] args) {
    MajorityElement majorityElement = new MajorityElement();
    int[] nums = new int[]{6, 6, 6, 7, 7};
    System.out.println(majorityElement.majorityElement(nums));
  }

  private int majorityElement(int[] nums) {
    int len = nums.length;
    int count = 0;
    int num = 0;
    for (int i = 0; i < len; i++) {
      if (count == 0) {
        num = nums[i];
      }
      if (num != nums[i]) {
        count--;
      } else {
        count++;
      }
    }
    return num;
  }
}