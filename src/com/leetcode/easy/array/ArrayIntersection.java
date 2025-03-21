package com.leetcode.easy.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    22/04/22, Time:    9:12 AM
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
public class ArrayIntersection {

  public static void main(String[] args) {
    ArrayIntersection arrayIntersection = new ArrayIntersection();
    int[] nums1 = new int[]{4, 9, 5};
    int[] nums2 = new int[]{9, 4, 9, 8, 4};
    int[] nums3 = arrayIntersection.intersect(nums1, nums2);
    System.out.println("nums3 = " + Arrays.toString(nums3));
  }

  private int[] intersect(int[] nums1, int[] nums2) {
    Set<Integer> set1 = new HashSet<>();
    for (Integer num : nums1) {
      set1.add(num);
    }
    Set<Integer> set2 = new HashSet<>();
    for (Integer num : nums2) {
      set2.add(num);
    }
    set1.retainAll(set2);
    int[] nums3 = new int[set1.size()];
    int i = 0;
    for (Integer num : set1) {
      nums3[i++] = num;
    }
    return nums3;
  }
}