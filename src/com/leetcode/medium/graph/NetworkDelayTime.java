package com.leetcode.medium.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    10/06/24,
 * Time:    4:35 pm
 * 743. Network Delay Time
 * https://leetcode.com/problems/network-delay-time/description/
 */
public class NetworkDelayTime {
  public static void main(String[] args) {
    NetworkDelayTime networkDelayTime = new NetworkDelayTime();
    int n = 4, k = 2;
    int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
    System.out.println(networkDelayTime.networkDelayTime(times, n, k));
  }

  private int networkDelayTime(int[][] times, int n, int k) {

    //Step 1
    Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
    for (int[] time : times) {
      int start = time[0], end = time[1], weight = time[2];
      graph.putIfAbsent(start, new HashMap<>());
      graph.get(start).put(end, weight);
    }

    // Step 2
    int[] distances = new int[n + 1];
    Arrays.fill(distances, Integer.MAX_VALUE);
    distances[k] = 0;
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] {k, 0});

    //Step 3:
    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int currentNode = current[0], currentWeight = current[1];
      for (int neighbor : graph.getOrDefault(currentNode, new HashMap<>()).keySet()) {
        int neighbourWeight = graph.get(currentNode).get(neighbor);
        if (distances[neighbor] > currentWeight + neighbourWeight) {
          distances[neighbor] = currentWeight + neighbourWeight;
          queue.add(new int[] {neighbor, currentWeight + neighbourWeight});
        }
      }
    }

    //Step 4:
    int result = 0;
    for (int i = 1; i <= n; i++) {
      if (result < distances[i]) {
        result = Math.max(result, distances[i]);
      }
    }
    return result == Integer.MAX_VALUE ? -1 : result;
  }
}