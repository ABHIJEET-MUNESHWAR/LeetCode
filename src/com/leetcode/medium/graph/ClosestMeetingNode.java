package com.leetcode.medium.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    14/06/24,
 * Time:    1:36 pm
 * 2359. Find Closest Node to Given Two Nodes
 * https://leetcode.com/problems/find-closest-node-to-given-two-nodes/description/
 */
public class ClosestMeetingNode {
  public static void main(String[] args) {
    ClosestMeetingNode closestMeetingNode = new ClosestMeetingNode();
    int[] edges = {2, 2, 3, -1};
    int node1 = 0, node2 = 1;
    System.out.println(closestMeetingNode.closestMeetingNodeDfs(edges, node1, node2));
    System.out.println(closestMeetingNode.closestMeetingNodeBfs(edges, node1, node2));
  }

  private int closestMeetingNodeBfs(int[] edges, int node1, int node2) {
    int n = edges.length;
    List<Integer> adjacencyList = new ArrayList<>();
    for (int i = 0; i < edges.length; i++) {
      adjacencyList.add(edges[i]);
    }
    int[] distance1 = new int[n];
    Arrays.fill(distance1, Integer.MAX_VALUE);
    int[] distance2 = new int[n];
    Arrays.fill(distance2, Integer.MAX_VALUE);
    distance1[node1] = 0;
    distance2[node2] = 0;
    bfs(edges, distance1, node1);
    bfs(edges, distance2, node2);

    int minDistanceNode = -1;
    int minDistanceTillNow = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      int maxDistance = Math.max(distance1[i], distance2[i]);
      if (minDistanceTillNow > maxDistance) {
        minDistanceTillNow = maxDistance;
        minDistanceNode = i;
      }
    }
    return minDistanceNode;
  }

  private void bfs(int[] edges, int[] distance, int node) {
    Queue<Integer> queue = new LinkedList<>();
    distance[node] = 0;
    queue.add(node);
    boolean[] visited = new boolean[edges.length];
    visited[node] = true;
    while (!queue.isEmpty()) {
      int current = queue.poll();
      int nextNode = edges[current];
      if (nextNode != -1 && !visited[nextNode]) {
        visited[nextNode] = true;
        distance[nextNode] = distance[current] + 1;
        queue.add(nextNode);
      }
    }
  }

  private int closestMeetingNodeDfs(int[] edges, int node1, int node2) {
    int n = edges.length;
    List<Integer> adjacencyList = new ArrayList<>();
    for (int i = 0; i < edges.length; i++) {
      adjacencyList.add(edges[i]);
    }
    int[] distance1 = new int[n];
    Arrays.fill(distance1, Integer.MAX_VALUE);
    int[] distance2 = new int[n];
    Arrays.fill(distance2, Integer.MAX_VALUE);
    boolean[] visited1 = new boolean[n];
    boolean[] visited2 = new boolean[n];
    distance1[node1] = 0;
    distance2[node2] = 0;
    dfs(edges, distance1, visited1, node1);
    dfs(edges, distance2, visited2, node2);

    int minDistanceNode = -1;
    int minDistanceTillNow = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      int maxDistance = Math.max(distance1[i], distance2[i]);
      if (minDistanceTillNow > maxDistance) {
        minDistanceTillNow = maxDistance;
        minDistanceNode = i;
      }
    }
    return minDistanceNode;
  }

  private void dfs(int[] edges, int[] distance, boolean[] visited, int node) {
    visited[node] = true;
    int next = edges[node];
    if (next != -1 && !visited[next]) {
      visited[next] = true;
      distance[next] = distance[node] + 1;
      dfs(edges, distance, visited, next);
    }
  }
}