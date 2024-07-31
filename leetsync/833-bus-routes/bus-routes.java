class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
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