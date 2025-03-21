package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    23/09/23,
 * Time:    2:29 pm
 * https://leetcode.com/problems/find-the-distinct-difference-array/
 */
public class DistinctDifferenceArray {
  public static void main(String[] args) {
    DistinctDifferenceArray distinctDifferenceArray = new DistinctDifferenceArray();
    int[] nums = {3, 2, 3, 4, 2};
    ArrayUtils.printArray(distinctDifferenceArray.distinctDifferenceArray(nums));
  }

  private int[] distinctDifferenceArray(int[] nums) {
    HashMap<Integer, Integer> prefixMap = new HashMap<>();
    HashMap<Integer, Integer> suffixMap = new HashMap<>();
    int size = nums.length;
    int[] answer = new int[size];
    for (int n : nums) {
      suffixMap.put(n, suffixMap.getOrDefault(n, 0) + 1);
    }
    for (int i = 0; i < size; i++) {
      int n = nums[i];
      prefixMap.put(n, prefixMap.getOrDefault(n, 0) + 1);
      suffixMap.put(n, suffixMap.get(n) - 1);
      if (suffixMap.get(n) == 0) {
        suffixMap.remove(n);
      }
      answer[i] = prefixMap.size() - suffixMap.size();
    }
    return answer;
  }
}