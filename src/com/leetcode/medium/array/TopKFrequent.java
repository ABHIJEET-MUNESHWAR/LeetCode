package com.leetcode.medium.array;

import com.leetcode.utils.ArrayUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    14/05/24,
 * Time:    9:26 pm
 * 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 */
public class TopKFrequent {
  public static void main(String[] args) {
    TopKFrequent topKFrequent = new TopKFrequent();
    int[] nums = {1, 1, 1, 2, 2, 3};
    int k = 2;
    ArrayUtils.printArray(topKFrequent.topKFrequent(nums, k));
  }

  private int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    PriorityQueue<Map.Entry<Integer, Integer>> mapHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
    mapHeap.addAll(map.entrySet());
    List<Integer> list = new ArrayList<>();
    while (list.size() < k) {
      list.add(mapHeap.poll().getKey());
    }
    return list.stream().mapToInt(i -> i).toArray();
  }
}