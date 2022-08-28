package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    27/08/22, Time:    6:58 PM
 * https://leetcode.com/problems/remove-element/
 */
public class RemoveElement {

  public static void main(String[] args) {
    RemoveElement removeElement = new RemoveElement();
    int[] nums = new int[]{5, 4};
    System.out.println(removeElement.removeElement(nums, 5));
  }

  private int removeElement(int[] nums, int val) {
    int m = 0;
    int len = nums.length;
    for (int i = 0; i < len; i++) {
      if (nums[i] != val) {
        nums[m++] = nums[i];
      }
    }
    return m;
  }
}