package com.leetcode.easy.array;

import java.util.PriorityQueue;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    24/04/23, Time:    9:19 am
 * https://leetcode.com/problems/last-stone-weight/
 */
public class LastStoneWeight {

  public static void main(String[] args) {
    LastStoneWeight lastStoneWeight = new LastStoneWeight();
    int[] stones = new int[]{2, 7, 4, 1, 8, 1};
    System.out.println(lastStoneWeight.lastStoneWeight(stones));
  }

  private int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
    for (int i : stones) {
      queue.offer(i);
    }
    while (queue.size() > 1) {
      queue.offer(queue.poll() - queue.poll());
    }
    return queue.poll();
  }
}