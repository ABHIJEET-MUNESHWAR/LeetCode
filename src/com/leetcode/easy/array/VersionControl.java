package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    11/08/22, Time:    4:28 PM
 */
public class VersionControl {

  int[] nums = new int[]{0, 0, 0, 0, 1, 1, 1};

  public boolean isBadVersion(int version) {
    return nums[version] == 1;
  }
}