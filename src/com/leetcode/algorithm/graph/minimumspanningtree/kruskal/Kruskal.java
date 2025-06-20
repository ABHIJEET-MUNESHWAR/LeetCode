package com.leetcode.algorithm.graph.minimumspanningtree.kruskal;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   20-06-2025
    Time:   11:48 am
    Minimum Spanning Tree using Kruskal's Algorithm
*/

import java.util.*;

// Edge representation
class Edge implements Comparable<Edge> {
    String source, target;
    int weight;

    Edge(String source, String target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}

// Disjoint Set Union (DSU) with path compression and union by rank
class DSU {
    private Map<String, String>  parentMap;
    private Map<String, Integer> rankMap;

    public DSU() {
        parentMap = new HashMap<>();
        rankMap = new HashMap<>();
    }

    public void makeSet(String node) {
        parentMap.put(node, node);
        rankMap.put(node, 0);
    }

    public String find(String node) {
        if (!parentMap.get(node).equals(node)) {
            parentMap.put(node, find(parentMap.get(node)));
        }
        return parentMap.get(node);
    }

    public boolean union(String u, String v) {
        String parentOfU = find(u);
        String parentOfV = find(v);
        if (parentOfU.equals(parentOfV)) {
            return false;
        }
        if (rankMap.get(parentOfU) < rankMap.get(parentOfV)) {
            parentMap.put(parentOfU, parentOfV);
        } else if (rankMap.get(parentOfU) > rankMap.get(parentOfV)) {
            parentMap.put(parentOfV, parentOfU);
        } else {
            parentMap.put(parentOfV, parentOfU);
            rankMap.put(parentOfU, rankMap.get(parentOfU) + 1);
        }
        return true;
    }

}

public class Kruskal {
    public static void main(String[] args) {
        Kruskal kruskal = new Kruskal();
        List<Edge> edges = Arrays.asList(
                new Edge("A", "B", 3),
                new Edge("A", "D", 1),
                new Edge("B", "D", 3),
                new Edge("B", "E", 1),
                new Edge("C", "E", 5),
                new Edge("C", "F", 4),
                new Edge("D", "E", 6),
                new Edge("E", "F", 2)
        );
        Set<String> nodes     = new HashSet<>(Arrays.asList("A", "B", "C", "D", "E", "F"));
        int         mstWeight = kruskal.kruskalMST(edges, nodes);
        System.out.println("🌲 Total weight of Minimum Spanning Tree: " + mstWeight);
    }

    private int kruskalMST(List<Edge> edges, Set<String> nodes) {
        DSU dsu = new DSU();
        for (String node : nodes) {
            dsu.makeSet(node);
        }

        // Sort edges by weight
        Collections.sort(edges);

        int        totalWeight = 0;
        List<Edge> mst         = new ArrayList<>();
        for (Edge edge : edges) {
            if (dsu.union(edge.source, edge.target)) {
                totalWeight += edge.weight;
                mst.add(edge);
            }
        }

        // Optional: print the MST edges
        System.out.println("🛠️ Edges in the MST:");
        for (Edge edge : mst) {
            System.out.println(edge.source + " -- " + edge.target + " == " + edge.weight);
        }

        return totalWeight;
    }
}
