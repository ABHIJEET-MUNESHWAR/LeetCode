package com.leetcode.algorithm.graph.bfs;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   19-07-2026
    Time:   01:11 pm
    https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
*/

import java.util.*;

public class CycleBFS {
    public boolean isCycle(int node, int[][] edges) {
        // Code here
        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
        for (int i = 0; i<node; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[node];
        for (int i = 0; i<node; i++) {
            if (!visited[i] && isCycleBFS(adj, visited, i)) {
                return true;
            }
        }
        return false;
    }
    private static class NodeParentPair {
        int node;
        int parent;
        NodeParentPair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }
    public boolean isCycleBFS(Map<Integer, ArrayList<Integer>> adj, boolean[] visited, int u) {
        visited[u] = true;
        Queue<NodeParentPair> queue = new LinkedList<>();
        queue.add(new NodeParentPair(u, -1));
        while (!queue.isEmpty()) {
            NodeParentPair pair = queue.poll();
            int node = pair.node;
            int parent = pair.parent;
            ArrayList<Integer> neighbours = adj.getOrDefault(node, new ArrayList<>());
            for (int v: neighbours) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(new NodeParentPair(v, node));
                } else if (v != parent) {
                    return true;
                }

            }
        }
        return false;
    }
}
