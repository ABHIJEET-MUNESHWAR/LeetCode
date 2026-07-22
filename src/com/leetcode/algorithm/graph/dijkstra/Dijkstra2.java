package com.leetcode.algorithm.graph.dijkstra;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   22-07-2026
    Time:   11:08 am
    https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
*/

import java.util.*;

public class Dijkstra2 {
    public int[] dijkstra(int V, int[][] edges, int src) {
        Map<Integer, ArrayList<int[]>> adj = new HashMap<>();
        for (int i = 0; i < V; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u      = edge[0];
            int v      = edge[1];
            int weight = edge[2];
            adj.get(u).add(new int[]{v, weight});
            adj.get(v).add(new int[]{u, weight});
        }
        int[] result = new int[V];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[src] = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.add(new int[]{0, src});
        while (!minHeap.isEmpty()) {
            int[] current         = minHeap.poll();
            int   currentDistance = current[0];
            int   u               = current[1];
            if (currentDistance > result[u]) {
                continue;
            }
            for (int[] neighbour : adj.get(u)) {
                int v      = neighbour[0];
                int weight = neighbour[1];
                if (result[v] > (weight + result[u])) {
                    result[v] = weight + result[u];
                    minHeap.add(new int[]{result[v], v});
                }
            }
        }
        for (int i = 0; i < V; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                result[i] = -1;
            }
        }
        return result;
    }
}
