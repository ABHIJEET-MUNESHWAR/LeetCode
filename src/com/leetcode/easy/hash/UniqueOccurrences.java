package com.leetcode.easy.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    08/10/23,
 * Time:    10:51am
 */
public class UniqueOccurrences {
  public static void main(String[] args) {
    UniqueOccurrences uniqueOccurrences = new UniqueOccurrences();
    int[] arr = {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
    System.out.println(uniqueOccurrences.uniqueOccurrences(arr));
  }

  private boolean uniqueOccurrences(int[] arr) {
    Map<Integer, Integer> numToFreqMap = new HashMap<>();
    for (int num : arr) {
      numToFreqMap.put(num, numToFreqMap.getOrDefault(num, 0) + 1);
    }
    Set<Integer> freqSet = new HashSet<>();
    for (Map.Entry<Integer, Integer> entry : numToFreqMap.entrySet()) {
      int value = entry.getValue();
      if (freqSet.contains(value)) {
        return false;
      } else {
        freqSet.add(value);
      }
    }
    return true;
  }
}