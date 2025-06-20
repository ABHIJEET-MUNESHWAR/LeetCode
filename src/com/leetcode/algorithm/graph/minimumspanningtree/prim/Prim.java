package com.leetcode.algorithm.graph.minimumspanningtree.prim;


import java.util.*;

/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   20-06-2025
    Time:   11:18 am
    Minimum Spanning Tree using Prim's Algorithm
*/
class Edge {
    String target;
    int    weight;

    public Edge(String target, int weight) {
        this.target = target;
        this.weight = weight;
    }
}

public class Prim {
    public static void main(String[] args) {
        Map<String, List<Edge>> graph = new HashMap<>();
        Prim                    prim  = new Prim();
        // Undirected graph: add both directions
        graph.put("A", Arrays.asList(new Edge("B", 3), new Edge("D", 1)));
        graph.put("B", Arrays.asList(new Edge("A", 3), new Edge("D", 3), new Edge("E", 1)));
        graph.put("C", Arrays.asList(new Edge("E", 5), new Edge("F", 4)));
        graph.put("D", Arrays.asList(new Edge("A", 1), new Edge("B", 3), new Edge("E", 6)));
        graph.put("E", Arrays.asList(new Edge("B", 1), new Edge("D", 6), new Edge("C", 5), new Edge("F", 2)));
        graph.put("F", Arrays.asList(new Edge("E", 2), new Edge("C", 4)));

        String startNode = "A";
        int    mstWeight = prim.primMST(graph, startNode);
        System.out.println("🌳 Total weight of Minimum Spanning Tree starting from " + startNode + ": " + mstWeight);

    }

    private int primMST(Map<String, List<Edge>> graph, String startNode) {
        // Min-heap for edges based on weight
        PriorityQueue<Edge> minHeap     = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        Set<String>         visited     = new HashSet<>();
        int                 totalWeight = 0;
        // Start from any node, add its edges
        visited.add(startNode);
        minHeap.addAll(graph.getOrDefault(startNode, new ArrayList<>()));
        while (!minHeap.isEmpty()) {
            Edge currentEdge = minHeap.poll();
            // Skip if node is already visited
            if (visited.contains(currentEdge.target)) {
                continue;
            }
            // Accept this edge in MST
            visited.add(currentEdge.target);
            totalWeight += currentEdge.weight;

            // Add all edges from the newly visited node
            for (Edge neighbour : graph.getOrDefault(currentEdge.target, new ArrayList<>())) {
                if (!visited.contains(neighbour.target)) {
                    minHeap.add(neighbour);
                }
            }
        }
        if (visited.size() != graph.size()) {
            throw new IllegalArgumentException("Graph is not connected, cannot form a Minimum Spanning Tree.");
        }
        return totalWeight;
    }
}
