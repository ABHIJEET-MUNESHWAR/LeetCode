package com.leetcode.medium.bit;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    31/05/24,
 * Time:    11:25 am
 * 260. Single Number III
 * https://leetcode.com/problems/single-number-iii/description/?envType=daily-question&envId=2024-05-31
 */
public class SingleNumberThree {
  public static void main(String[] args) {
    SingleNumberThree singleNumberThree = new SingleNumberThree();
    int[] nums = {1, 2, 1, 3, 2, 5};
    ArrayUtils.printArray(singleNumberThree.singleNumber(nums));
  }

  private int[] singleNumber(int[] nums) {
    int[] result = new int[2];
    int xOrOfAll = 0;
    for (int num : nums) {
      xOrOfAll ^= num;
    }
    int mask = xOrOfAll & (-xOrOfAll);
    int groupA = 0, groupB = 0;
    for (int num : nums) {
      if ((num & mask) == 0) {
        groupA ^= num;
      } else {
        groupB ^= num;
      }
    }
    result[0] = groupA;
    result[1] = groupB;
    return result;
  }
}