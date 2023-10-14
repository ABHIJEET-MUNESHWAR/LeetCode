package com.leetcode.easy.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    14/10/23,
 * Time:    3:16pm
 * https://leetcode.com/problems/kth-distinct-string-in-an-array/
 */
public class KthDistinct {
  public static void main(String[] args) {
    KthDistinct kthDistinct = new KthDistinct();
    String[] arr = {"d", "b", "c", "b", "c", "a"};
    int k = 2;
    System.out.println(kthDistinct.kthDistinct(arr, k));
  }

  private String kthDistinct(String[] arr, int k) {
    Map<String, Integer> charToFreqMap = new HashMap<>();
    for (String str : arr) {
      charToFreqMap.put(str, charToFreqMap.getOrDefault(str, 0) + 1);
    }
    int i = 1;
    for (int j = 0; j < arr.length; j++) {
      if (charToFreqMap.get(arr[j]) == 1) {
        if (i == k) {
          return arr[j];
        }
        i++;
      }
    }
    return "";
  }
}