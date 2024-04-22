package com.leetcode.easy.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    22/04/24,
 * Time:    9:10 am
 * 1971. Find if Path Exists in Graph
 * https://leetcode.com/problems/find-if-path-exists-in-graph/description/?envType=daily-question&envId=2024-04-21
 */
public class FindIfPathExistsInGraph {
  public static void main(String[] args) {
    FindIfPathExistsInGraph findIfPathExistsInGraph = new FindIfPathExistsInGraph();
    int n = 6, source = 0, destination = 5;
    int[][] edges = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
    System.out.println(findIfPathExistsInGraph.validPath(n, edges, source, destination));
  }

  private boolean validPath(int n, int[][] edges, int source, int destination) {
    // Create Adjacency List
    List<List<Integer>> adjacencyList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adjacencyList.add(new ArrayList<>());
    }
    // Fill values
    for (int i = 0; i < edges.length; i++) {
      int u = edges[i][0];
      int v = edges[i][1];
      adjacencyList.get(u).add(v);
      adjacencyList.get(v).add(u);
    }
    boolean[] isVisited = new boolean[n];
    return dfs(adjacencyList, source, destination, isVisited);
  }

  private boolean dfs(List<List<Integer>> adjacencyList, int currentNode, int destination,
                      boolean[] isVisited) {
    isVisited[currentNode] = true;
    if (currentNode == destination) {
      return true;
    }
    // Visit all neighbours of current node
    for (Integer neighbor : adjacencyList.get(currentNode)) {
      if (!isVisited[neighbor]) {
        isVisited[neighbor] = true;
        boolean isFound = dfs(adjacencyList, neighbor, destination, isVisited);
        if (isFound) {
          return true;
        }
      }
    }
    return false;
  }
}