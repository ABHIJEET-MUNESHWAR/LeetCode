package com.leetcode.medium.slidingwindow;

import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    23/06/24,
 * Time:    11:27 am
 * 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/?envType=daily-question&envId=2024-06-23
 */
public class LongestSubarray {
  public static void main(String[] args) {
    LongestSubarray longestSubarray = new LongestSubarray();
    /*int[] nums = {10, 1, 2, 4, 7, 2};
    int limit = 5;*/
    int[] nums = {1, 5, 6, 7, 8, 10, 6, 5, 6};
    int limit = 4;
    System.out.println(longestSubarray.longestSubarraySlidingWindow(nums, limit));
    System.out.println(longestSubarray.longestSubarraySlidingWindowWithTreeMap(nums, limit));
  }

  private int longestSubarraySlidingWindowWithTreeMap(int[] nums, int limit) {
    int maxLength = 0;
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    int size = nums.length;
    int left = 0, right = 0;

    while (right < size) {

      treeMap.put(nums[right], treeMap.getOrDefault(nums[right], 0) + 1);

      while ((treeMap.lastKey() - treeMap.firstKey()) > limit) {

        treeMap.put(nums[left], treeMap.getOrDefault(nums[left], 0) - 1);
        if (treeMap.get(nums[left]) == 0) {
          treeMap.remove(nums[left]);
        }
        left++;
      }
      maxLength = Math.max(maxLength, right - left + 1);
      right++;
    }
    return maxLength;
  }

  private int longestSubarraySlidingWindow(int[] nums, int limit) {
    int maxLength = 0;
    int size = nums.length;
    int left = 0, right = 0;
    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
    while (right < size) {
      minHeap.add(new int[] {nums[right], right});
      maxHeap.add(new int[] {nums[right], right});
      while ((maxHeap.peek()[0] - minHeap.peek()[0]) > limit) {

        left = Math.min(maxHeap.peek()[1], minHeap.peek()[1]) + 1;

        while (maxHeap.peek()[1] < left) {
          maxHeap.poll();
        }

        while (minHeap.peek()[1] < left) {
          minHeap.poll();
        }
      }
      maxLength = Math.max(maxLength, right - left + 1);
      right++;
    }
    return maxLength;
  }
}