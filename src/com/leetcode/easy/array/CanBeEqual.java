package com.leetcode.easy.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    14/10/23,
 * Time:    4:51pm
 * https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays/
 */
public class CanBeEqual {
  public static void main(String[] args) {
    CanBeEqual canBeEqual = new CanBeEqual();
    int[] target = {1, 2, 3, 4};
    int[] arr = {2, 4, 1, 3};
    System.out.println(canBeEqual.canBeEqual1(target, arr));
    System.out.println(canBeEqual.canBeEqual2(target, arr));
  }

  private boolean canBeEqual2(int[] target, int[] arr) {
    int[] count = new int[1001];
    int size = target.length;
    for (int i = 0; i < size; i++) {
      count[target[i]]++;
      count[arr[i]]--;
    }
    for (int i = 0; i < 1001; i++) {
      if (count[i] != 0) {
        return false;
      }
    }
    return true;
  }

  private boolean canBeEqual1(int[] target, int[] arr) {
    Map<Integer, Integer> targetMap = new HashMap<>();
    for (int num : target) {
      targetMap.put(num, targetMap.getOrDefault(num, 0) + 1);
    }
    for (int num : arr) {
      targetMap.put(num, targetMap.getOrDefault(num, 0) - 1);
    }
    for (Map.Entry<Integer, Integer> entry : targetMap.entrySet()) {
      if (entry.getValue() != 0) {
        return false;
      }
    }
    return true;
  }
}