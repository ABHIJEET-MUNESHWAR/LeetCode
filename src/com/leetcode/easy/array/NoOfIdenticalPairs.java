package com.leetcode.easy.array;

import java.util.HashMap;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    19/01/23, Time:    11:55 am
 * https://leetcode.com/problems/number-of-good-pairs/
 */
public class NoOfIdenticalPairs {

  public static void main(String[] args) {
    NoOfIdenticalPairs noOfIdenticalPairs = new NoOfIdenticalPairs();
    int[] nums = new int[]{1, 2, 3, 1, 1, 3};
    System.out.println(noOfIdenticalPairs.numIdenticalPairs(nums));
  }

  private int numIdenticalPairs(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int size = nums.length;
    int total = 0;
    for (int i = 0; i < size; i++) {
      int count = map.getOrDefault(nums[i], 0);
      total += count;
      map.put(nums[i], count + 1);
    }
    return total;
  }
}