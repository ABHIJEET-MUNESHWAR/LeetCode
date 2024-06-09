package com.leetcode.medium.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    09/06/24,
 * Time:    4:14 pm
 * 785. Is Graph Bipartite?
 * https://leetcode.com/problems/is-graph-bipartite/description/
 */
public class IsBipartite {
  public static void main(String[] args) {
    IsBipartite isBipartite = new IsBipartite();
    int[][] graph = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
    System.out.println(isBipartite.isBipartiteDFS(graph));
    System.out.println(isBipartite.isBipartiteBFS(graph));
  }

  private boolean isBipartiteBFS(int[][] graph) {
    int vortexCount = graph.length;
    int[] colors = new int[vortexCount];
    Arrays.fill(colors, -1);
    // Red:   1
    // Green: 0
    for (int i = 0; i < vortexCount; i++) {
      if (colors[i] == -1) {
        if (!checkBipartiteBFS(graph, i, colors, 1)) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean checkBipartiteBFS(int[][] graph, int currentNode, int[] colors, int currentColor) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(currentNode);
    colors[currentNode] = currentColor;
    while (!queue.isEmpty()) {
      int node = queue.poll();
      for (int neighbor : graph[node]) { 
        if (colors[neighbor] == colors[node]) {
          return false;
        } else if (colors[neighbor] == -1) {
          colors[neighbor] = 1 - colors[node];
          queue.add(neighbor);
        }
      }
    }
    return true;
  }

  private boolean isBipartiteDFS(int[][] graph) {
    int vertexCount = graph.length;
    int[] colors = new int[vertexCount];
    Arrays.fill(colors, -1); // No nodes coloured at the start
    // Red:   1
    // Green: 0
    for (int i = 0; i < vertexCount; i++) {
      if (colors[i] == -1) {
        if (!checkBipartiteDFS(graph, i, colors, 1)) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean checkBipartiteDFS(int[][] graph, int currentNode, int[] colors, int currentColor) {
    colors[currentNode] = currentColor;
    for (int neighbor : graph[currentNode]) {
      if (colors[neighbor] == colors[currentNode]) {
        return false;
      }
      if (colors[neighbor] == -1) {
        int colourOfNeighbor = 1 - currentColor;
        if (!checkBipartiteDFS(graph, neighbor, colors, colourOfNeighbor)) {
          return false;
        }
      }
    }
    return true;
  }
}