package com.leetcode.medium.bit;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    30/04/24,
 * Time:    9:36 pm
 * 2433. Find The Original Array of Prefix Xor
 * https://leetcode.com/problems/find-the-original-array-of-prefix-xor/description/
 */
public class FindTheOriginalArrayOfPrefixXor {
  public static void main(String[] args) {
    FindTheOriginalArrayOfPrefixXor findTheOriginalArrayOfPrefixXor = new FindTheOriginalArrayOfPrefixXor();
    int[] pref = {5, 2, 0, 3, 1};
    ArrayUtils.printArray(findTheOriginalArrayOfPrefixXor.findArray(pref));
  }

  private int[] findArray(int[] pref) {
    int[] result = new int[pref.length];
    result[0] = pref[0];
    for (int i = 1; i < pref.length; i++) {
      result[i] = pref[i] ^ pref[i - 1];
    }
    return result;
  }
}