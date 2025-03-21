package com.leetcode.medium.graph;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/06/24,
 * Time:    1:24 am
 * 1319. Number of Operations to Make Network Connected
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/
 */
public class MakeConnected {
  public static void main(String[] args) {
    MakeConnected makeConnected = new MakeConnected();
    int n = 4;
    int[][] connections = {{0, 1}, {0, 2}, {1, 2}};
    System.out.println(makeConnected.makeConnected(n, connections));
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

  private int makeConnected(int n, int[][] connections) {
    int size = connections.length;
    if (size < (n - 1)) {
      return -1;
    }
    int[] parents = new int[n + 1];
    int[] rank = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      parents[i] = i;
      rank[i] = 0;
    }
    int components = n;
    for (int[] connection : connections) {
      if (find(connection[0], parents) != find(connection[1], parents)) {
        union(connection[0], connection[1], parents, rank);
        components--;
      }
    }
    return components - 1;
  }
}