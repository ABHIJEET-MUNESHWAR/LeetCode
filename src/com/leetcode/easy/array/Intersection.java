package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    10/03/24,
 * Time:    6:10 am
 * https://leetcode.com/problems/intersection-of-two-arrays/?envType=daily-question&envId=2024-03-10
 */
public class Intersection {
  public static void main(String[] args) {
    Intersection intersection = new Intersection();
    int[] nums1 = {1, 2, 2, 1};
    int[] nums2 = {2, 2};
    ArrayUtils.printArray(intersection.intersectionTwoSets(nums1, nums2));
    ArrayUtils.printArray(intersection.intersectionTwoLoops(nums1, nums2));
    ArrayUtils.printArray(intersection.intersectionBinarySearch(nums1, nums2));
  }

  private int[] intersectionBinarySearch(int[] nums1, int[] nums2) {
    Arrays.sort(nums2);
    Set<Integer> intersectionSet = new HashSet<>();
    for (int num : nums1) {
      if (binarySearch(nums2, num)) {
        intersectionSet.add(num);
      }
    }
    int[] answer = new int[intersectionSet.size()];
    int i = 0;
    for (int num : intersectionSet) {
      answer[i++] = num;
    }
    return answer;
  }

  private boolean binarySearch(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] == target) {
        return true;
      }
      if (nums[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return false;
  }

  private int[] intersectionTwoLoops(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int size1 = nums1.length;
    int size2 = nums2.length;
    int i = 0, j = 0;
    Set<Integer> intersectionSet = new HashSet<>();
    while ((i < size1) && (j < size2)) {
      if (nums1[i] > nums2[j]) {
        j++;
      } else if (nums1[i] < nums2[j]) {
        i++;
      } else {
        intersectionSet.add(nums1[i]);
        i++;
        j++;
      }
    }
    int[] answer = new int[intersectionSet.size()];
    i = 0;
    for (int num : intersectionSet) {
      answer[i++] = num;
    }
    return answer;
  }

  private int[] intersectionTwoSets(int[] nums1, int[] nums2) {
    Set<Integer> set1 = new HashSet<>();
    Set<Integer> set2 = new HashSet<>();
    for (int num : nums1) {
      set1.add(num);
    }
    for (int num : nums2) {
      if (set1.contains(num)) {
        set2.add(num);
      }
    }
    int[] answer = new int[set2.size()];
    int i = 0;
    for (int num : set2) {
      answer[i++] = num;
    }
    return answer;
  }
}