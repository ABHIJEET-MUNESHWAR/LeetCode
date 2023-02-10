package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;

import java.util.ArrayList;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    10/02/23, Time:    10:21 am
 * https://leetcode.com/problems/decompress-run-length-encoded-list/
 */
public class DecompressRunLengthEncodedList {

  public static void main(String[] args) {
    DecompressRunLengthEncodedList decompressRunLengthEncodedList = new DecompressRunLengthEncodedList();
    int[] nums = new int[]{1, 2, 3, 4};
    ArrayUtils.printArray(decompressRunLengthEncodedList.decompressRLElist(nums));
  }

  private int[] decompressRLElist(int[] nums) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    for (int i = 1; i < nums.length; i += 2) {
      for (int j = 0; j < nums[i - 1]; j++) {
        result.add(nums[i]);
      }
    }
    return result.stream().mapToInt(i -> i).toArray();
  }
}