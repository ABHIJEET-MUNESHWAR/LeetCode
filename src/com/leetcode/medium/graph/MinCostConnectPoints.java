package com.leetcode.medium.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    16/06/24,
 * Time:    8:05 pm
 * 1584. Min Cost to Connect All Points
 * https://leetcode.com/problems/min-cost-to-connect-all-points/description/
 */
public class MinCostConnectPoints {
  public static void main(String[] args) {
    MinCostConnectPoints minCostConnectPoints = new MinCostConnectPoints();
    int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
    System.out.println(minCostConnectPoints.minCostConnectPoints(points));
  }

  class Edge implements Comparable<Edge> {
    int node;
    int distance;

    public Edge(int node, int distance) {
      this.node = node;
      this.distance = distance;
    }

    @Override
    public int compareTo(Edge that) {
      return this.distance - that.distance;
    }
  }

  private int minCostConnectPoints(int[][] points) {
    List<List<Edge>> graph = new ArrayList<>();
    int totalVertices = points.length;
    for (int i = 0; i < totalVertices; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 0; i < totalVertices; i++) {
      for (int j = i + 1; j < totalVertices; j++) {
        int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
        graph.get(i).add(new Edge(j, distance));
        graph.get(j).add(new Edge(i, distance));
      }
    }
    return prims(totalVertices, graph);
  }

  private int prims(int totalVertices, List<List<Edge>> graph) {
    int totalSum = 0;
    boolean[] visited = new boolean[totalVertices];
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    pq.add(new Edge(0, 0));
    while (!pq.isEmpty()) {
      Edge edge = pq.poll();
      if (visited[edge.node]) {
        continue;
      }
      visited[edge.node] = true;
      totalSum += edge.distance;
      for (Edge neighbor : graph.get(edge.node)) {
        if (!visited[neighbor.node]) {
          pq.add(neighbor);
        }
      }
    }
    return totalSum;
  }
}