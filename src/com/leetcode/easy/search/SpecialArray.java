package com.leetcode.easy.search;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    27/05/24,
 * Time:    2:05 pm
 * 1608. Special Array With X Elements Greater Than or Equal X
 * https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/description/?envType=daily-question&envId=2024-05-27
 */
public class SpecialArray {
  public static void main(String[] args) {
    SpecialArray specialArray = new SpecialArray();
    int[] nums = {3, 6, 7, 7, 0};
    //int[] nums = {3, 5};
    System.out.println(specialArray.specialArrayBruteForce(nums));
    System.out.println(specialArray.specialArrayBinarySearch(nums));
    System.out.println(specialArray.specialArrayImprovedBinarySearch(nums));
    System.out.println(specialArray.specialArrayPrefixSum(nums));
  }

  private int specialArrayPrefixSum(int[] nums) {
    int size = nums.length;
    // Frequency array
    int[] frequencyMap = new int[size + 1];

    // Populate the frequency array
    for (int i = 0; i < size; i++) {
      if (nums[i] > size) {
        frequencyMap[size]++;
      } else {
        frequencyMap[nums[i]]++;
      }
    }

    // Calculate prefix sum from the end
    int cumulativeSum = 0;
    for (int i = size; i >= 0; i--) {
      cumulativeSum += frequencyMap[i];
      if (i == cumulativeSum) {
        return i;
      }
    }
    return -1;
  }

  private int specialArrayImprovedBinarySearch(int[] nums) {
    int size = nums.length;
    Arrays.sort(nums);
    int xLeft = 0;
    int xRight = size;
    while (xLeft <= xRight) {
      int xMid = (xLeft + xRight) / 2;
      int index = lowerBoundBinarySearch(nums, xMid);
      if (size - index == xMid) {
        return xMid;
      } else if (size - index > xMid) {
        xLeft = xMid + 1;
      } else {
        xRight = xMid - 1;
      }
    }
    return -1;
  }

  private int specialArrayBinarySearch(int[] nums) {
    int size = nums.length;
    Arrays.sort(nums);
    for (int x = 0; x <= size; x++) {
      int index = lowerBoundBinarySearch(nums, x);
      if ((size - index) == x) {
        return x;
      }
    }
    return -1;
  }

  private int lowerBoundBinarySearch(int[] nums, int x) {
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] < x) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;
  }

  private int specialArrayBruteForce(int[] nums) {
    int size = nums.length;
    for (int x = 0; x <= size; x++) {
      int totalGreaterElements = getTotalGreaterElements(nums, x);
      if (totalGreaterElements == x) {
        return x;
      }
    }
    return -1;
  }

  private int getTotalGreaterElements(int[] nums, int x) {
    int size = nums.length;
    int totalGreaterElements = 0;
    for (int j = 0; j < size; j++) {
      if (nums[j] >= x) {
        totalGreaterElements++;
      }
    }
    return totalGreaterElements;
  }
}