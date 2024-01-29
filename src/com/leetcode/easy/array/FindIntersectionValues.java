package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;
import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    29/01/24,
 * Time:    9:48 am
 * https://leetcode.com/problems/find-common-elements-between-two-arrays/
 */
public class FindIntersectionValues {
  public static void main(String[] args) {
    FindIntersectionValues findIntersectionValues = new FindIntersectionValues();
    int[] nums1 = {4, 3, 2, 3, 1};
    int[] nums2 = {2, 2, 5, 2, 3, 6};
    ArrayUtils.printArray(findIntersectionValues.findIntersectionValues(nums1, nums2));
  }

  private int[] findIntersectionValues(int[] nums1, int[] nums2) {
    int[] answer = new int[2];
    Set<Integer> set1 = new HashSet<>();
    Set<Integer> set2 = new HashSet<>();
    for (int num : nums1) {
      set1.add(num);
    }
    for (int num : nums2) {
      set2.add(num);
    }
    for (int num : nums1) {
      if (set2.contains(num)) {
        answer[0]++;
      }
    }
    for (int num : nums2) {
      if (set1.contains(num)) {
        answer[1]++;
      }
    }
    return answer;
  }
}