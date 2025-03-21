package com.leetcode.medium.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    14/06/24,
 * Time:    3:02 pm
 */
public class MinScore {
  public static void main(String[] args) {
    MinScore minScore = new MinScore();
    int n = 4;
    int[][] roads = {{1, 2, 9}, {2, 3, 6}, {2, 4, 5}, {1, 4, 7}};
    System.out.println(minScore.minScoreUnionFind(n, roads));
    System.out.println(minScore.minScoreDfs(n, roads));
    System.out.println(minScore.minScoreBfs(n, roads));
  }

  private int minScoreBfs(int n, int[][] roads) {
    Map<Integer, List<Pair>> graph = new HashMap<>();
    for (int i = 0; i <= n; i++) {
      graph.putIfAbsent(i, new ArrayList<>());
    }
    for (int[] road : roads) {
      graph.get(road[0]).add(new Pair(road[1], road[2]));
      graph.get(road[1]).add(new Pair(road[0], road[2]));
    }
    bfs(graph, 1);
    return minScore;
  }

  private void bfs(Map<Integer, List<Pair>> graph, int currentNode) {
    boolean[] visited = new boolean[graph.size()];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(currentNode);
    visited[currentNode] = true;
    while (!queue.isEmpty()) {
      int node = queue.poll();
      for (Pair pair : graph.get(node)) {
        minScore = Math.min(minScore, pair.score);
        if (!visited[pair.node]) {
          visited[pair.node] = true;
          queue.add(pair.node);
        }
      }
    }
  }

  class Pair {
    int node;
    int score;

    public Pair(int node, int score) {
      this.node = node;
      this.score = score;
    }
  }

  int minScore = Integer.MAX_VALUE;

  private int minScoreDfs(int n, int[][] roads) {
    Map<Integer, List<Pair>> graph = new HashMap<>();
    for (int i = 0; i <= n; i++) {
      graph.putIfAbsent(i, new ArrayList<>());
    }
    for (int[] road : roads) {
      graph.get(road[0]).add(new Pair(road[1], road[2]));
      graph.get(road[1]).add(new Pair(road[0], road[2]));
    }
    boolean[] visited = new boolean[n + 1];
    dfs(graph, visited, 1);
    return minScore;
  }

  private void dfs(Map<Integer, List<Pair>> graph, boolean[] visited, int currentNode) {
    visited[currentNode] = true;
    for (Pair pair : graph.get(currentNode)) {
      minScore = Math.min(minScore, pair.score);
      if (!visited[pair.node]) {
        dfs(graph, visited, pair.node);
      }
    }
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

  private int minScoreUnionFind(int n, int[][] roads) {
    int[] parent = new int[n + 1];
    int[] rank = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      parent[i] = i;
    }
    int minPath = Integer.MAX_VALUE;
    for (int[] road : roads) {
      union(road[0], road[1], parent, rank);
    }
    int parentOfZero = find(1, parent);
    for (int[] road : roads) {
      int parentOfRoad = find(road[0], parent);
      if (parentOfRoad == parentOfZero) {
        minPath = Math.min(minPath, road[2]);
      }
    }
    return minPath;
  }
}