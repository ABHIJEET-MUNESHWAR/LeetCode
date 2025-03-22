package com.leetcode.medium.graph;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   22-03-2025
    Time:   07:50 pm
    2685. Count the Number of Complete Components
    https://leetcode.com/problems/count-the-number-of-complete-components/description/?envType=daily-question&envId=2025-03-22
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

public class CountCompleteComponents {
    public static void main(String[] args) {
        CountCompleteComponents ccc = new CountCompleteComponents();
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {3, 4}};
        System.out.println(ccc.countCompleteComponents(n, edges));
    }

    public int countCompleteComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int result = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            int[] info = new int[2];
            dfs(i, adj, visited, info);
            if (info[0] * (info[0] - 1) == info[1]) {
                result++;
            }
        }
        return result;
    }

    public void dfs(int i, Map<Integer, List<Integer>> adj, boolean[] visited, int[] info) {
        visited[i] = true;
        info[0]++;
        info[1] += adj.getOrDefault(i, new ArrayList<>()).size();
        for (int ngbr : adj.getOrDefault(i, new ArrayList<>())) {
            if (!visited[ngbr]) {
                bfs(ngbr, adj, visited, info);
            }
        }
    }

    public void bfs(int i, Map<Integer, List<Integer>> adj, boolean[] visited, int[] info) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            info[0]++;
            info[1] += adj.getOrDefault(curr, new ArrayList<>()).size();
            for (int ngbr : adj.getOrDefault(curr, new ArrayList<>())) {
                if (!visited[ngbr]) {
                    visited[ngbr] = true;
                    queue.add(ngbr);
                }
            }
        }
    }
}
