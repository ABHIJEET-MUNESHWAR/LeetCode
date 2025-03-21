package com.leetcode.medium.design;

import com.leetcode.utils.ArrayUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    11/07/24,
 * Time:    8:38 pm
 */
public class MostFrequentIDs {
  public static void main(String[] args) {
    MostFrequentIDs mostFrequentIDs = new MostFrequentIDs();
    int[] nums = {2, 3, 2, 1};
    int[] freq = {3, 2, -3, 1};
    ArrayUtils.printLongArray(mostFrequentIDs.mostFrequentIDs(nums, freq));
  }

  private long[] mostFrequentIDs(int[] nums, int[] freq) {
    int n = nums.length;
    Map<Long, Long> map = new HashMap<>();
    PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0])); //{freq, ID}
    long[] result = new long[n];
    for (int i = 0; i < n; i++) {
      long id = nums[i];
      long frequency = freq[i];
      map.put(id, map.getOrDefault(id, 0L) + frequency);
      pq.add(new long[] {map.get(id), id});
      while (!pq.isEmpty() && map.get(pq.peek()[1]) != pq.peek()[0]) {
        pq.poll();
      }
      result[i] = pq.peek()[0];
    }
    return result;
  }
}