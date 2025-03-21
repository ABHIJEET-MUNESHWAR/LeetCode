package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    22/04/22, Time:    9:12 AM
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
public class ArrayIntersection2 {

  public static void main(String[] args) {
    ArrayIntersection2 arrayIntersection2 = new ArrayIntersection2();
    int[] nums1 = new int[]{4, 7, 9, 7, 6, 7};
    int[] nums2 = new int[]{5, 0, 0, 6, 1, 6, 2, 2, 4};
    int[] nums3 = arrayIntersection2.intersect(nums1, nums2);
    System.out.println("nums3 = " + Arrays.toString(nums3));
  }

  private int[] intersect(int[] nums1, int[] nums2) {
    int l1 = nums1.length;
    int l2 = nums2.length;
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    ArrayList<Integer> num3ArrayList = new ArrayList<>();
    int j = 0, i = 0;
    if (l1 < l2) {
      while (i < l1 && j < l2) {
        if (nums1[i] == nums2[j]) {
          num3ArrayList.add(nums1[i]);
          i++;
          j++;
        } else if (nums1[i] < nums2[j]) {
          i++;
        } else {
          j++;
        }
      }
    } else {
      j = 0;
      i = 0;
      while (j < l1 && i < l2) {
        if (nums2[i] == nums1[j]) {
          num3ArrayList.add(nums1[j]);
          i++;
          j++;
        } else if (nums2[i] < nums1[j]) {
          i++;
        } else {
          j++;
        }
      }
    }
    return num3ArrayList.stream().mapToInt(m -> m).toArray();
  }
}