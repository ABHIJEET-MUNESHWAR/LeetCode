package com.leetcode.easy.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    22/04/22, Time:    8:57 AM
 */
public class ContainsDuplicate {

  public static void main(String[] args) {
    ContainsDuplicate containsDuplicate = new ContainsDuplicate();
    int[] nums = new int[]{1, 2, 3, 1};
    if (containsDuplicate.containsDuplicate(nums)) {
      System.out.println("True");
    } else {
      System.out.println("False");
    }
  }

  private boolean containsDuplicate(int[] nums) {
    Set<Integer> integerSet = new HashSet<>();
    for (Integer num : nums) {
      integerSet.add(num);
    }
    return integerSet.size() != nums.length;
  }

}