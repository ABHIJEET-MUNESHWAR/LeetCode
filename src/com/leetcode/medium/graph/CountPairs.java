package com.leetcode.medium.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/06/24,
 * Time:    7:55 am
 * 2316. Count Unreachable Pairs of Nodes in an Undirected Graph
 * https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/description/
 */
public class CountPairs {
  public static void main(String[] args) {
    CountPairs countPairs = new CountPairs();
    int n = 7;
    int[][] edges = {{0, 2}, {0, 5}, {2, 4}, {1, 6}, {5, 4}};
    System.out.println(countPairs.countPairs(n, edges));
  }

  public int find(int i, int[] parent) {
    if (parent[i] == i) {
      return i;
    }
    return parent[i] = find(parent[i], parent);
  }

  public void union(int i, int j, int[] parent, int[] rank) {
    int parentOfI = find(i, parent);
    int parentOfJ = find(j, parent);
    if (parentOfI == parentOfJ) {
      return;
    }
    if (rank[parentOfI] > rank[parentOfJ]) {
      parent[parentOfJ] = parentOfI;
    } else if (rank[parentOfI] < rank[parentOfJ]) {
      parent[parentOfI] = parentOfJ;
    } else {
      parent[parentOfI] = parentOfJ;
      rank[parentOfJ]++;
    }
  }

  private long countPairs(int n, int[][] edges) {
    Map<Integer, Integer> componentVsSizeMap = new HashMap<>();
    int[] parents = new int[n];
    int[] rank = new int[n];
    for (int i = 0; i < n; i++) {
      parents[i] = i;
      rank[i] = 0;
    }
    for (int[] edge : edges) {
      union(edge[0], edge[1], parents, rank);
    }
    for (int i = 0; i < n; i++) {
      int parentOfI = find(i, parents);
      componentVsSizeMap.put(parentOfI, componentVsSizeMap.getOrDefault(parentOfI, 0) + 1);
    }
    int remaining = n;
    long result = 0;
    for (Map.Entry<Integer, Integer> entry : componentVsSizeMap.entrySet()) {
      int componentSize = entry.getValue();
      result += componentSize * (remaining - componentSize);
      remaining -= componentSize;
    }
    return result;
  }
}