package com.leetcode.easy.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/10/23,
 * Time:    8:48pm
 */
public class NumberOfPoints {
  public static void main(String[] args) {
    NumberOfPoints numberOfPoints = new NumberOfPoints();
    List<List<Integer>> nums = new ArrayList<>();
    List<Integer> nums1 = new ArrayList<>();
    nums1.add(3);
    nums1.add(6);
    nums.add(nums1);
    List<Integer> nums2 = new ArrayList<>();
    nums2.add(1);
    nums2.add(5);
    nums.add(nums2);
    List<Integer> nums3 = new ArrayList<>();
    nums3.add(4);
    nums3.add(7);
    nums.add(nums3);
    System.out.println(numberOfPoints.numberOfPoints(nums));
  }

  private int numberOfPoints(List<List<Integer>> nums) {
    int count = 0;
    boolean[] cars = new boolean[101];
    for (List<Integer> numList : nums) {
      int start = numList.get(0);
      int end = numList.get(1);
      for (int i = start; i <= end; i++) {
        cars[i] = true;
      }
    }
    for (boolean car : cars) {
      if (car) {
        count++;
      }
    }
    return count;
  }
}