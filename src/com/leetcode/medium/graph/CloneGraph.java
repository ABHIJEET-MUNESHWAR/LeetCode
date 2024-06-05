package com.leetcode.medium.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    05/06/24,
 * Time:    4:00 pm
 * 133. Clone Graph
 * https://leetcode.com/problems/clone-graph/description/
 */
public class CloneGraph {
  class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }

  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }
    Node copy = new Node(node.val);
    Node[] visited = new Node[101];
    Arrays.fill(visited, null);
    dfs(node, copy, visited);
    return copy;
  }

  private void dfs(Node node, Node copy, Node[] visited) {
    visited[copy.val] = copy;
    for (Node neighbor : node.neighbors) {
      if (visited[neighbor.val] == null) {
        Node newNode = new Node(neighbor.val);
        copy.neighbors.add(newNode);
        dfs(neighbor, newNode, visited);
      } else {
        copy.neighbors.add(visited[neighbor.val]);
      }
    }
  }
}