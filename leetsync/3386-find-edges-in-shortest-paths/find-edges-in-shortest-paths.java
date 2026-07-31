class Solution {
    public boolean[] findAnswer(int n, int[][] edges) {
        int totalEdges = edges.length;
        Map<Integer, List<int[]>> adjacencyMap = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            adjacencyMap.computeIfAbsent(u, key -> new ArrayList<>()).add(new int[] { v, weight });
            adjacencyMap.computeIfAbsent(v, key -> new ArrayList<>()).add(new int[] { u, weight });
        }
        long[] sourceMinDistance = dijkstra(n, adjacencyMap, 0);
        long[] destinationMinDistance = dijkstra(n, adjacencyMap, n - 1);
        boolean[] answer = new boolean[totalEdges];
        for (int i = 0; i < totalEdges; i++) {
            int[] edge = edges[i];
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            boolean direction1 = sourceMinDistance[u] != Long.MAX_VALUE && destinationMinDistance[v] != Long.MAX_VALUE
                    && ((sourceMinDistance[u] + weight + destinationMinDistance[v]) == sourceMinDistance[n - 1]);
            boolean direction2 = sourceMinDistance[v] != Long.MAX_VALUE && destinationMinDistance[u] != Long.MAX_VALUE
                    && ((sourceMinDistance[v] + weight + destinationMinDistance[u]) == sourceMinDistance[n - 1]);
            if (direction1 || direction2) {
                answer[i] = true;
            }
        }
        return answer;
    }

    public long[] dijkstra(int n, Map<Integer, List<int[]>> adjacencyMap, int source) {
        long[] minDistance = new long[n];
        Arrays.fill(minDistance, Long.MAX_VALUE);
        minDistance[source] = 0;
        PriorityQueue<long[]> minHeap = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        minHeap.offer(new long[] { 0, source });
        while (!minHeap.isEmpty()) {
            long[] current = minHeap.poll();
            long currentWeight = current[0];
            int currentNode = (int) current[1];
            if (currentWeight > minDistance[currentNode]) {
                continue;
            }
            for (int[] v : adjacencyMap.getOrDefault(currentNode, Collections.emptyList())) {
                int nextNode = v[0];
                int nextWeight = v[1];
                if (minDistance[nextNode] > (minDistance[currentNode] + nextWeight)) {
                    minDistance[nextNode] = (minDistance[currentNode] + nextWeight);
                    minHeap.offer(new long[] { minDistance[nextNode], nextNode });
                }
            }
        }
        return minDistance;
    }
}