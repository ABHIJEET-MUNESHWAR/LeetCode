package com.leetcode.medium.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    08/06/24,
 * Time:    10:26 pm
 * 547. Number of Provinces
 * https://leetcode.com/problems/number-of-provinces/description/
 */
public class NumberOfProvinces {
  public static void main(String[] args) {
    NumberOfProvinces numberOfProvinces = new NumberOfProvinces();
    int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
    System.out.println(numberOfProvinces.findCircleNumUnionFind(isConnected));
    System.out.println(numberOfProvinces.findCircleNumDFS(isConnected));
  }

  private int findCircleNumDFS(int[][] isConnected) {
    int n = isConnected.length;
    boolean[] visited = new boolean[n];
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        dfs(isConnected, visited, i);
        count++;
      }
    }
    return count;
  }

  private void dfs(int[][] isConnected, boolean[] visited, int i) {
    for (int j = 0; j < isConnected.length; j++) {
      if (isConnected[i][j] == 1 && !visited[j]) {
        visited[j] = true;
        dfs(isConnected, visited, j);
      }
    }
  }

  public int find(int i, int[] parent) {
    if (i == parent[i]) {
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

  private int findCircleNumUnionFind(int[][] isConnected) {
    int n = isConnected.length;
    int[] parent = new int[n];
    int[] rank = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (isConnected[i][j] == 1) {
          union(i, j, parent, rank);
        }
      }
    }
    int provinces = 0;
    for (int i = 0; i < n; i++) {
      if (parent[i] == i) {
        provinces++;
      }
    }
    return provinces;
  }
}