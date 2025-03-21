package com.leetcode.medium.queue;

import java.util.PriorityQueue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    03/06/24,
 * Time:    10:06 pm
 * 215. Kth Largest Element in an Array
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 */
public class FindKthLargest {
  public static void main(String[] args) {
    FindKthLargest findKthLargest = new FindKthLargest();
    int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
    int k = 4;
    System.out.println(findKthLargest.findKthLargest(nums, k));
  }

  private int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int num : nums) {
      minHeap.add(num);
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }
    return minHeap.peek();
  }
}