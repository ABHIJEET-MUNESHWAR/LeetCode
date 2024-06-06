package com.leetcode.medium.graph;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    06/06/24,
 * Time:    10:44 am
 * 684. Redundant Connection
 * https://leetcode.com/problems/redundant-connection/description/
 */
public class RedundantConnection {
  public static void main(String[] args) {
    RedundantConnection redundantConnection = new RedundantConnection();
    int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
    ArrayUtils.printArray(redundantConnection.findRedundantConnection(edges));
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
      rank[parentOfI]++;
    }
  }

  private int[] findRedundantConnection(int[][] edges) {
    int size = edges.length;
    int[] parent = new int[size + 1];
    int[] rank = new int[size + 1];
    for (int i = 1; i <= size; i++) {
      parent[i] = i;
      rank[i] = 0;
    }
    for (int[] edge : edges) {
      if (find(edge[0], parent) == find(edge[1], parent)) {
        return edge;
      }
      union(edge[0], edge[1], parent, rank);
    }
    return new int[] {-1, -1};
  }
}