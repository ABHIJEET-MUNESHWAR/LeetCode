package com.leetcode.easy.graph;

import com.leetcode.utils.DisjointSetUnion;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    19/12/22, Time:    8:02 am
 * https://leetcode.com/problems/find-if-path-exists-in-graph/
 */
public class CheckIfPathExistsInGraph {

  private boolean seen;

  public static void main(String[] args) {
    CheckIfPathExistsInGraph checkIfPathExistsInGraph = new CheckIfPathExistsInGraph();
    int n = 3;
    int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 0}};
    int source = 0;
    int destination = 2;
    System.out.println(checkIfPathExistsInGraph.validPathBFS(n, edges, source, destination));
    System.out.println(checkIfPathExistsInGraph.validPathDFS(n, edges, source, destination));
    System.out.println(checkIfPathExistsInGraph.validPathUnionFind(n, edges, source, destination));
  }

  private boolean validPathUnionFind(int n, int[][] edges, int source, int destination) {
    DisjointSetUnion disjointSetUnion = new DisjointSetUnion(n);
    for (int[] edge : edges) {
      disjointSetUnion.union(edge[0], edge[1]);
    }
    return disjointSetUnion.areConnected(source, destination);
  }

  private boolean validPathBFS(int n, int[][] edges, int source, int destination) {
    boolean[] visited = new boolean[n];
    HashSet<Integer>[] graph = new HashSet[n];
    for (int i = 0; i < n; i++) {
      graph[i] = new HashSet<>();
    }
    for (int[] edge : edges) {
      graph[edge[0]].add(edge[1]);
      graph[edge[1]].add(edge[0]);
    }
    if (graph[source].contains(destination)) {
      return true;
    }
    Queue<Integer> queue = new PriorityQueue<>();
    visited[source] = true;
    queue.add(source);
    int current;
    while (!queue.isEmpty()) {
      current = queue.poll();
      if (current == destination) {
        return true;
      }
      for (int neighbour : graph[current]) {
        if (!visited[neighbour]) {
          visited[neighbour] = true;
          queue.add(neighbour);
        }
      }
    }
    return false;
  }

  private boolean validPathDFS(int n, int[][] edges, int source, int destination) {
    boolean[] visited = new boolean[n];
    HashSet<Integer>[] graph = new HashSet[n];
    for (int i = 0; i < n; i++) {
      graph[i] = new HashSet<>();
    }
    for (int[] edge : edges) {
      graph[edge[0]].add(edge[1]);
      graph[edge[1]].add(edge[0]);
    }
    if (graph[source].contains(destination)) {
      return true;
    }
    visited[source] = true;
    seen = false;
    dfs(graph, visited, source, destination);
    return seen;
  }

  private void dfs(HashSet<Integer>[] graph, boolean[] visited, int source, int destination) {
    if (!visited[source] && !seen) {
      if (source == destination) {
        seen = true;
        return;
      }
    }
    visited[source] = true;
    for (Integer neighbour : graph[source]) {
      dfs(graph, visited, neighbour, destination);
    }
  }
}