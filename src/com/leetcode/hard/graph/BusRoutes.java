package com.leetcode.hard.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    31/07/24,
 * Time:    11:25 pm
 * 815. Bus Routes
 * https://leetcode.com/problems/bus-routes/description/
 */
public class BusRoutes {
    public static void main(String[] args) {
        BusRoutes busRoutes = new BusRoutes();
        int[][] routes = {{1, 2, 7}, {3, 6, 7}};
        int source = 1, target = 6;
        System.out.println(busRoutes.numBusesToDestination(routes, source, target));
    }

    private int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        // Create a map from the bus stop to all the routes that include this stop.
        Map<Integer, List<Integer>> busRouteToStopIndexMap = new HashMap<>();
        int n = routes.length;
        for (int i = 0; i < n; i++) {
            int[] route = routes[i];
            int m = route.length;
            for (int j = 0; j < m; j++) {
                busRouteToStopIndexMap.computeIfAbsent(route[j], k -> new ArrayList<>()).add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[501];
        // Insert all the routes in the queue that have the source stop.
        for (int route : busRouteToStopIndexMap.getOrDefault(source, new ArrayList<>())) {
            queue.add(route);
            visited[route] = true;
        }
        int busCount = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int route = queue.poll();
                // Iterate over the stops in the current route.
                for (int stop : routes[route]) {
                    // Return the current count if the target is found.
                    if (stop == target) {
                        return busCount;
                    }
                    // Iterate over the next possible routes from the current stop.
                    for (int nextNode : busRouteToStopIndexMap.getOrDefault(stop, Collections.emptyList())) {
                        if (!visited[nextNode]) {
                            queue.add(nextNode);
                            visited[nextNode] = true;
                        }
                    }
                }
            }
            busCount++;
        }
        return -1;
    }
}