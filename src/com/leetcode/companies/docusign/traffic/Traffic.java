package com.leetcode.companies.docusign.traffic;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   20/09/26
    Time:   7:59 am
*/

import java.util.*;

class Edge {
    int to;
    int distance;
    int time;

    public Edge(int to, int distance, int time) {
        this.to = to;
        this.distance = distance;
        this.time = time;
    }
}

class State {
    int  node;
    long time;
    long distance;

    public State(int node, long time, long distance) {
        this.node = node;
        this.time = time;
        this.distance = distance;
    }
}

public class Traffic {

    private void findBestRoute(int m, int n, int[][] roads, int source, int destination) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int[] road : roads) {
            int u        = road[0];
            int v        = road[1];
            int distance = road[2];
            int time     = road[3];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Edge(v, distance, time));
        }
        long[] minTime     = new long[n + 1];
        long[] minDistance = new long[n + 1];

        Arrays.fill(minTime, Integer.MAX_VALUE);
        Arrays.fill(minDistance, Integer.MAX_VALUE);

        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);

        PriorityQueue<State> minHeap = new PriorityQueue<>(
                (a, b) -> {
                    if (a.time != b.time) {
                        return Long.compare(a.time, b.time);
                    }
                    return Long.compare(a.distance, b.distance);
                }
        );
        minTime[source] = 0;
        minDistance[source] = 0;
        minHeap.offer(new State(source, 0, 0));
        while (!minHeap.isEmpty()) {
            State currentNode = minHeap.poll();
            int   u           = currentNode.node;
            if (currentNode.time > minTime[u] || currentNode.distance > minDistance[u]) {
                continue;
            }
            if (u == destination) {
                break;
            }
            if (!graph.containsKey(u)) {
                continue;
            }
            for (Edge edge : graph.get(u)) {
                int  v           = edge.to;
                long newTime     = currentNode.time + edge.time;
                long newDistance = currentNode.distance + edge.distance;
                if (newTime < minTime[v] || (newTime == minTime[v] && newDistance < minDistance[v])) {
                    minTime[v] = newTime;
                    minDistance[v] = newDistance;
                    parent[v] = u;
                    minHeap.offer(new State(v, newTime, newDistance));
                }
            }
        }
        if (minDistance[destination] == Integer.MAX_VALUE) {
            System.out.println("No Route");
        } else {
            List<Integer> path    = new ArrayList<>();
            int           current = destination;
            while (current != -1) {
                path.add(current);
                current = parent[current];
            }
            Collections.reverse(path);
            System.out.println("Minimum travel time: " + minTime[destination]);
            System.out.println("Minimum distance: " + minDistance[destination]);
            System.out.println("Path: " + path);
            for (int i = 0; i < path.size(); i++) {
                if (i != path.size() - 1) {
                    System.out.print(path.get(i) + " -> ");
                } else {
                    System.out.print(path.get(i));
                }
            }
        }
    }

    public static void main(String[] args) {
        int m = 7;
        int n = 5;
        int[][] roads = {
                {1, 2, 5, 10},
                {1, 3, 7, 8},
                {2, 4, 8, 12},
                {3, 4, 10, 14},
                {2, 3, 2, 3},
                {4, 5, 4, 6},
                {3, 5, 15, 18}
        };
        int     source      = 1;
        int     destination = 5;
        Traffic traffic     = new Traffic();
        traffic.findBestRoute(m, n, roads, source, destination);
    }
}
