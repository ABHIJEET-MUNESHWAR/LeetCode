package com.leetcode.easy.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    24/09/23,
 * Time:    11:53 am
 * https://leetcode.com/problems/sum-of-unique-elements/
 */
public class SumOfUnique {
  public static void main(String[] args) {
    SumOfUnique sumOfUnique = new SumOfUnique();
    int[] nums = {1,2,3,4,5};
    System.out.println(sumOfUnique.sumOfUnique(nums));
  }

  private int sumOfUnique(int[] nums) {
    int sum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int n : nums) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == 1) {
        sum += entry.getKey();
      }
    }
    return sum;
  }
}