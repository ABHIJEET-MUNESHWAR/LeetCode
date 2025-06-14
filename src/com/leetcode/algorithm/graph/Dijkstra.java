package com.leetcode.algorithm.graph;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   14-06-2025
    Time:   08:31 am
    Dijkstra's Algorithm
*/

import java.util.*;

class Pair {
    String node;
    int    weight;

    Pair(String node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

public class Dijkstra {

    public static void main(String[] args) {
        Map<String, List<Pair>> graph = new HashMap<>();
        graph.put("A", Arrays.asList(new Pair("B", 4), new Pair("C", 1)));
        graph.put("B", Arrays.asList(new Pair("E", 4)));
        graph.put("C", Arrays.asList(new Pair("B", 2), new Pair("D", 4)));
        graph.put("D", Arrays.asList(new Pair("E", 4)));
        graph.put("E", new ArrayList<>()); // No neighbors

        String               source        = "A";
        Map<String, Integer> shortestPaths = dijkstra(graph, source);
        System.out.println("Shortest paths from " + source + ":");
        for (Map.Entry<String, Integer> entry : shortestPaths.entrySet()) {
            System.out.println("To " + entry.getKey() + " : " + entry.getValue());
        }
    }

    private static Map<String, Integer> dijkstra(Map<String, List<Pair>> graph, String source) {
        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<Pair>  pq        = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.weight));
        pq.offer(new Pair(source, 0));

        for (String node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(source, 0);
        while (!pq.isEmpty()) {
            Pair   current       = pq.poll();
            String currentNode   = current.node;
            int    currentWeight = current.weight;

            if (currentWeight > distances.get(currentNode)) {
                continue; // Skip if we have already found a better path
            }
            // Traverse neighbors
            List<Pair> neighbors = graph.getOrDefault(currentNode, new ArrayList<>());
            for (Pair neighbor : neighbors) {
                int newDistance = currentWeight + neighbor.weight;
                if (newDistance < distances.get(neighbor.node)) {
                    distances.put(neighbor.node, newDistance);
                    pq.offer(new Pair(neighbor.node, newDistance));
                }
            }
        }
        return distances;
    }
}
