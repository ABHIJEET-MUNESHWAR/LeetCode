package com.leetcode.algorithm.graph.dfs;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   19-07-2026
    Time:   12:33 pm
    https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CycleDFS {
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
            if (!visited[i] && isCycleDFS(adj, visited, i, -1)) {
                return true;
            }
        }
        return false;
    }
    public boolean isCycleDFS(Map<Integer, ArrayList<Integer>> adj, boolean[] visited, int u, int parent) {
        visited[u] = true;
        for (int v: adj.get(u)) {
            if (v == parent) {
                continue;
            }
            if (visited[v]) {
                return true;
            }
            if (isCycleDFS(adj, visited, v, u)) {
                return true;
            }
        }
        return false;
    }
}
