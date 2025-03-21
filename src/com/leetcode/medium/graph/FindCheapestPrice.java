package com.leetcode.medium.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    09/06/24,
 * Time:    4:57 pm
 * 787. Cheapest Flights Within K Stops
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
 */
public class FindCheapestPrice {
  public static void main(String[] args) {
    FindCheapestPrice findCheapestPrice = new FindCheapestPrice();
    int n = 4, src = 0, dst = 3, k = 1;
    int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
    System.out.println(findCheapestPrice.findCheapestPrice(n, flights, src, dst, k));
  }

  private int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    int[] minDistances = new int[n];
    Arrays.fill(minDistances, Integer.MAX_VALUE);
    Map<Integer, List<int[]>> adj = new HashMap<>();
    for (int[] flight : flights) {
      int from = flight[0], to = flight[1], cost = flight[2];
      adj.computeIfAbsent(from, key -> new ArrayList<>()).add(new int[] {to, cost});
    }
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] {src, 0});
    minDistances[src] = 0;
    int level = 0;
    while (!queue.isEmpty() && level <= k) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] currentNode = queue.poll();
        int u = currentNode[0], d = currentNode[1];
        List<int[]> neighbors = adj.getOrDefault(u, Collections.emptyList());
        for (int[] neighbor : neighbors) {
          int to = neighbor[0], cost = neighbor[1];
          if (minDistances[to] > (cost + d)) {
            minDistances[to] = cost + d;
            queue.add(new int[] {to, d + cost});
          }
        }
      }
      level++;
    }
    return minDistances[dst] == Integer.MAX_VALUE ? -1 : minDistances[dst];
  }
}