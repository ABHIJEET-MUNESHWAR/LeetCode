package com.leetcode.easy.bit;

import com.leetcode.utils.ArrayUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    08/10/23,
 * Time:    12:20pm
 */
public class SortByBits {
  public static void main(String[] args) {
    SortByBits sortByBits = new SortByBits();
    int[] arr = {1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
    ArrayUtils.printArray(sortByBits.sortByBits(arr));
  }

  private int[] sortByBits(int[] arr) {
    List<Integer> answerList = new ArrayList<>();
    TreeMap<Integer, List<Integer>> binaryToFreqTreeMap = new TreeMap<>();
    for (int num : arr) {
      int bitCount = getBitCount(num);
      List<Integer> freqList = new ArrayList<>();
      if (binaryToFreqTreeMap.containsKey(bitCount)) {
        freqList = binaryToFreqTreeMap.get(bitCount);
      }
      freqList.add(num);
      Collections.sort(freqList);
      binaryToFreqTreeMap.put(bitCount, freqList);
    }
    for (Map.Entry<Integer, List<Integer>> entry : binaryToFreqTreeMap.entrySet()) {
      List<Integer> nums = entry.getValue();
      answerList.addAll(nums);
    }
    return answerList.stream().mapToInt(i -> i).toArray();
  }

  private int getBitCount(int num) {
    int count = 0;
    while (num > 0) {
      count += num & 1;
      num >>= 1;
    }
    return count;
  }
}