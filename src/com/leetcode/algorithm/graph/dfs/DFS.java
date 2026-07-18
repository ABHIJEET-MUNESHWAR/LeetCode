package com.leetcode.algorithm.graph.dfs;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   18-07-2026
    Time:   10:03 pm
*/

import java.util.ArrayList;

public class DFS {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int                size    = adj.size();
        boolean[]          visited = new boolean[size];
        ArrayList<Integer> result  = new ArrayList<>();
        dfs(adj, 0, visited, result);
        return result;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited, ArrayList<Integer> result) {
        visited[node] = true;
        result.add(node);
        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                dfs(adj, neighbour, visited, result);
            }
        }
    }
}
