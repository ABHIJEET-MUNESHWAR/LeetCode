package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/07/23,
 * Time:    11:36 am
 * https://leetcode.com/problems/sort-the-people/
 */
public class SortPeople {
  public static void main(String[] args) {
    SortPeople sortPeople = new SortPeople();
    String[] names = {"Mary", "John", "Emma"};
    int[] heights = {180, 165, 170};
    ArrayUtils.printArray(sortPeople.sortPeople(names, heights));
  }

  private String[] sortPeople(String[] names, int[] heights) {
    int length = names.length;
    String[] ans = new String[length];
    Map<Integer, String> heightToNamesMap = new HashMap<>();
    for (int i = 0; i < length; i++) {
      heightToNamesMap.put(heights[i], names[i]);
    }
    Arrays.sort(heights);
    for (int i = length - 1, j = 0; i >= 0; i--) {
      ans[j++] = heightToNamesMap.get(heights[i]);
    }
    return ans;
  }
}