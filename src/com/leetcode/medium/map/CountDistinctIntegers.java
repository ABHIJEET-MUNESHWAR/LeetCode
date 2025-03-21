package com.leetcode.medium.map;

import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    11/05/24,
 * Time:    4:19 pm
 * 2442. Count Number of Distinct Integers After Reverse Operations
 * https://leetcode.com/problems/count-number-of-distinct-integers-after-reverse-operations/description/
 */
public class CountDistinctIntegers {
  public static void main(String[] args) {
    CountDistinctIntegers countDistinctIntegers = new CountDistinctIntegers();
    int[] nums = {1, 13, 10, 12, 31};
    System.out.println(countDistinctIntegers.countDistinctIntegers(nums));
  }

  private int countDistinctIntegers(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
      set.add(reverse(num));
    }
    return set.size();
  }

  private Integer reverse(int num) {
    int reverse = 0;
    while (num != 0) {
      reverse = reverse * 10 + num % 10;
      num /= 10;
    }
    return reverse;
  }
}