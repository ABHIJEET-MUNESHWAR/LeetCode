package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    11/10/22, Time:    7:04 AM
 * https://leetcode.com/problems/next-greater-element-i/
 */
public class NextGreaterElement1 {

  public static void main(String[] args) {
    NextGreaterElement1 nextGreaterElement = new NextGreaterElement1();
    int[] nums1 = new int[]{4, 1, 2};
    int[] nums2 = new int[]{1, 3, 4, 2};
    int[] num3 = nextGreaterElement.nextGreaterElement(nums1, nums2);
  }

  private int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int[] nums3 = new int[nums1.length];
    for (int i = 0; i < nums1.length; i++) {
      int j = 0;
      int size = nums2.length;
      boolean isFound = false;
      while (j < size) {
        if (nums1[i] == nums2[j]) {
          break;
        }
        j++;
      }
      while (j < size) {
        if (nums1[i] < nums2[j]) {
          nums3[i] = nums2[j];
          isFound = true;
          break;
        }
        j++;
      }
      if (isFound == false) {
        nums3[i] = -1;
      }
    }
    return nums3;
  }
}