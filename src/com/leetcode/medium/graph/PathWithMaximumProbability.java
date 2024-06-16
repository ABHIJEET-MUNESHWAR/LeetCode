package com.leetcode.medium.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    15/06/24,
 * Time:    7:36 pm
 * 1514. Path with Maximum Probability
 * https://leetcode.com/problems/path-with-maximum-probability/description/
 */
public class PathWithMaximumProbability {
  public static void main(String[] args) {
    PathWithMaximumProbability pathWithMaximumProbability = new PathWithMaximumProbability();
    int n = 3;
    int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
    double[] succProb = {0.5, 0.5, 0.2};
    int start = 0, end = 2;
    System.out.println(pathWithMaximumProbability.maxProbability(n, edges, succProb, start, end));
  }

  class Edge {
    int node;
    double probability;

    public Edge(int node, double probability) {
      this.node = node;
      this.probability = probability;
    }
  }

  private double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
    List<Edge>[] graph = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }
    for (int i = 0; i < edges.length; i++) {
      int[] edge = edges[i];
      graph[edge[0]].add(new Edge(edge[1], succProb[i]));
      graph[edge[1]].add(new Edge(edge[0], succProb[i]));
    }
    return dijkstra(n, graph, start, end);
  }

  public double dijkstra(int vertices, List<Edge>[] graph, int start, int end) {
    double[] distances = new double[vertices];
    distances[start] = 1;
    PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Double.compare(b.probability, a.probability));
    pq.add(new Edge(start, 1));
    while (!pq.isEmpty()) {
      Edge edge = pq.poll();
      int node = edge.node;
      double distance = edge.probability;
      for (Edge neighbour : graph[node]) {
        int neighbourNode = neighbour.node;
        double neighbourDistance = neighbour.probability;
        if (distances[neighbourNode] < (neighbourDistance * distance)) {
          distances[neighbourNode] = (neighbourDistance * distance);
          pq.add(new Edge(neighbourNode, distances[neighbourNode]));
        }
      }
    }
    return distances[end];
  }
}