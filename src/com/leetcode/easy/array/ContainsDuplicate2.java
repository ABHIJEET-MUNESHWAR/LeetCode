package com.leetcode.easy.array;

import java.util.HashMap;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    02/09/22, Time:    9:52 AM
 * https://leetcode.com/problems/contains-duplicate-ii/
 */
public class ContainsDuplicate2 {

  public static void main(String[] args) {
    ContainsDuplicate2 containsDuplicate2 = new ContainsDuplicate2();
    /*int[] nums = {1, 2, 3, 1};
    int k = 3;*/
    /*int[] nums = {1, 0, 1, 1};
    int k = 1;*/
    int[] nums = {1, 2, 3, 1, 2, 3};
    int k = 2;
    System.out.println(containsDuplicate2.containsNearbyDuplicate(nums, k));
  }

  private boolean containsNearbyDuplicate(int[] nums, int k) {
    int size = nums.length;
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < size; i++) {
      if (map.containsKey(nums[i])) {
        if (i - map.get(nums[i]) <= k) {
          return true;
        }
      }
      map.put(nums[i], i);
    }
    return false;
  }
}