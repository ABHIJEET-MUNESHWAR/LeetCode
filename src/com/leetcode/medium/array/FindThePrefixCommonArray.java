package com.leetcode.medium.array;

import com.leetcode.utils.ArrayUtils;
import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    10/05/24,
 * Time:    10:53 am
 * 2657. Find the Prefix Common Array of Two Arrays
 * https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/description/
 */
public class FindThePrefixCommonArray {
  public static void main(String[] args) {
    FindThePrefixCommonArray findThePrefixCommonArray = new FindThePrefixCommonArray();
    int[] a = {1, 3, 2, 4};
    int[] b = {3, 1, 2, 4};
    ArrayUtils.printArray(findThePrefixCommonArray.findThePrefixCommonArray(a, b));
  }

  private int[] findThePrefixCommonArray(int[] a, int[] b) {
    int size = a.length;
    int[] result = new int[size];
    int[] visited = new int[size + 1];
    int currentCount = 0;
    for (int i = 0; i < size; i++) {
      if (++visited[a[i]] == 2) {
        currentCount++;
      }
      if (++visited[b[i]] == 2) {
        currentCount++;
      }
      result[i] = currentCount;
    }
    return result;
  }
}