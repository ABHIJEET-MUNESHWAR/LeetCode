package com.leetcode.easy.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    04/01/24,
 * Time:    1:43am
 * https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/description/
 */
public class SumCounts {
  public static void main(String[] args) {
    SumCounts sumCounts = new SumCounts();
    List<Integer> nums = Arrays.asList(1, 2, 1);
    System.out.println(sumCounts.sumCounts(nums));
  }

  private int sumCounts(List<Integer> list) {
    int n = list.size();
    int ans = 0;
    for (int i = 0; i < n; i++) {
      HashSet<Integer> set = new HashSet<>();
      for (int j = i; j < n; j++) {
        int a = list.get(j);
        set.add(a);
        int size = set.size();
        ans += size * size;
      }
    }
    return ans;
  }
}