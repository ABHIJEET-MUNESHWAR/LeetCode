package com.leetcode.hard.graph;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    30/06/24,
 * Time:    9:34 am
 * 1579. Remove Max Number of Edges to Keep Graph Fully Traversable
 * https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/description/?envType=daily-question&envId=2024-06-30
 */
public class MaxNumEdgesToRemove {
  public static void main(String[] args) {
    MaxNumEdgesToRemove maxNumEdgesToRemove = new MaxNumEdgesToRemove();
    int n = 4;
    int[][] edges = {{3, 1, 2}, {3, 2, 3}, {1, 1, 3}, {1, 2, 4}, {1, 1, 2}, {2, 3, 4}};
    System.out.println(maxNumEdgesToRemove.maxNumEdgesToRemove(n, edges));
  }

  class DSU {
    private int[] parent;
    private int[] rank;
    private int components;

    public DSU(int n) {
      parent = new int[n + 1];
      rank = new int[n + 1];
      components = n;
      for (int i = 1; i <= n; i++) {
        parent[i] = i;
      }
    }

    public int find(int i) {
      if (i == parent[i]) {
        return i;
      }
      return parent[i] = find(parent[i]);
    }

    public void union(int i, int j) {
      int parentOfI = find(i);
      int parentOfJ = find(j);
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
      components--;
    }

    public boolean isSingleComponent() {
      return components == 1;
    }
  }


  private int maxNumEdgesToRemove(int n, int[][] edges) {
    Arrays.sort(edges, (v1, v2) -> v2[0] - v1[0]);
    DSU aliceDsu = new DSU(n);
    DSU bobDsu = new DSU(n);
    int addedEdges = 0;
    for (int[] edge : edges) {
      int type = edge[0];
      int u = edge[1];
      int v = edge[2];
      if (type == 3) {
        boolean isAdded = false;
        if (aliceDsu.find(u) != aliceDsu.find(v)) {
          aliceDsu.union(u, v);
          isAdded = true;
        }
        if (bobDsu.find(u) != bobDsu.find(v)) {
          bobDsu.union(u, v);
          isAdded = true;
        }
        if (isAdded) {
          addedEdges++;
        }
      } else if (type == 2) {
        if (bobDsu.find(u) != bobDsu.find(v)) {
          bobDsu.union(u, v);
          addedEdges++;
        }
      } else if (type == 1) {
        if (aliceDsu.find(u) != aliceDsu.find(v)) {
          aliceDsu.union(u, v);
          addedEdges++;
        }
      }
    }
    if (aliceDsu.isSingleComponent() && bobDsu.isSingleComponent()) {
      return edges.length - addedEdges;
    }
    return -1;
  }
}