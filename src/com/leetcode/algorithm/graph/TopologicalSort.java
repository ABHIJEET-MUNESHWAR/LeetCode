package com.leetcode.algorithm.graph;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   14-06-2025
    Time:   10:30 pm
    Topological Sort
*/

import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        TopologicalSort topologicalSort = new TopologicalSort();
        // Example graph: Directed Acyclic Graph (DAG)
        Map<String, List<String>> graph = new HashMap<>();

        graph.put("A", Arrays.asList("C"));
        graph.put("B", Arrays.asList("C", "D"));
        graph.put("C", Arrays.asList("E"));
        graph.put("D", Arrays.asList("F"));
        graph.put("E", Arrays.asList("H", "F"));
        graph.put("F", Arrays.asList("G"));
        graph.put("G", new ArrayList<>());
        graph.put("H", new ArrayList<>());

        List<String> topoOrder = topologicalSort.topologicalSort(graph);

        System.out.println("Topological Sort Order:");
        for (String node : topoOrder) {
            System.out.print(node + " ");
        }
    }

    private List<String> topologicalSort(Map<String, List<String>> graph) {
        Set<String>   visited = new HashSet<>();
        Stack<String> stack   = new Stack<>();
        for (String node : graph.keySet()) {
            if (!visited.contains(node)) {
                topoDfs(graph, node, visited, stack);
            }
        }
        List<String> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    private void topoDfs(Map<String, List<String>> graph, String node, Set<String> visited, Stack<String> stack) {
        visited.add(node);
        List<String> neighbours = graph.getOrDefault(node, new ArrayList<>());
        for (String neighbour : neighbours) {
            if (!visited.contains(neighbour)) {
                topoDfs(graph, neighbour, visited, stack);
            }
        }
        stack.push(node); // add to stack once all neighbors are visited
    }
}
