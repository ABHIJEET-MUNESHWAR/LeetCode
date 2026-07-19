package com.leetcode.algorithm.graph.bfs;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   18-07-2026
    Time:   10:20 pm
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result  = new ArrayList<>();
        int                size    = adj.size();
        boolean[]          visited = new boolean[size];
        bfs(adj, 0, visited, result);
        return result;
    }

    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited, ArrayList<Integer> result) {
        visited[node] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int pop = queue.poll();
            result.add(pop);
            for (int i = 0; i < adj.get(pop).size(); i++) {
                int current = adj.get(pop).get(i);
                if (!visited[current]) {
                    queue.add(current);
                    visited[current] = true;
                }
            }
        }
        return result;
    }
}
