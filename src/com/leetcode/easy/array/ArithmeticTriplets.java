package com.leetcode.easy.array;

import java.util.HashSet;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    13/03/23, Time:    9:59 am
 * https://leetcode.com/problems/number-of-arithmetic-triplets/
 */
public class ArithmeticTriplets {

  public static void main(String[] args) {
    ArithmeticTriplets arithmeticTriplets = new ArithmeticTriplets();
    int[] nums = new int[]{4, 5, 6, 7, 8, 9};
    int diff = 2;
    System.out.println(arithmeticTriplets.arithmeticTriplets(nums, diff));
  }

  private int arithmeticTriplets(int[] nums, int diff) {
    int count = 0;
    HashSet<Integer> hashSet = new HashSet<>();
    for (int num : nums) {
      hashSet.add(num);
    }
    for (Integer num : nums) {
      if (hashSet.contains(num + diff) && hashSet.contains(num + diff * 2)) {
        count++;
      }
    }
    return count;
  }
}