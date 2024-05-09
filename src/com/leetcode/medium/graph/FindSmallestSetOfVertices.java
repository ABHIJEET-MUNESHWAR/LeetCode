package com.leetcode.medium.graph;

import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    09/05/24,
 * Time:    5:02 pm
 * 1557. Minimum Number of Vertices to Reach All Nodes
 * https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/description/
 */
public class FindSmallestSetOfVertices {
  public static void main(String[] args) {
    FindSmallestSetOfVertices findSmallestSetOfVertices = new FindSmallestSetOfVertices();
    int n = 4;
    List<List<Integer>> edges = new ArrayList<>();
    edges.add(getEdge(1, 2));
    edges.add(getEdge(3, 2));
    edges.add(getEdge(1, 3));
    edges.add(getEdge(1, 0));
    edges.add(getEdge(0, 2));
    edges.add(getEdge(0, 3));
    ListUtils.printList(findSmallestSetOfVertices.findSmallestSetOfVertices(n, edges));
  }

  private List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
    List<Integer> answer = new ArrayList<>();
    int[] visited = new int[n];
    for (List<Integer> edge : edges) {
      visited[edge.get(1)] = 1;
    }
    for (int i = 0; i < n; i++) {
      if (visited[i] == 0) {
        answer.add(i);
      }
    }
    return answer;
  }

  public static List<Integer> getEdge(int u, int v) {
    List<Integer> edge = new ArrayList<>();
    edge.add(u);
    edge.add(v);
    return edge;
  }
}