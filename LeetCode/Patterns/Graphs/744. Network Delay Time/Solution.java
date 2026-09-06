class Solution {
    public int networkDelayTime(int[][] edges, int n, int src) {
        Map<Integer, ArrayList<int[]>> adj = new HashMap<>();
        for (int i = 0; i < n + 1; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            adj.get(u).add(new int[] { v, weight });
        }
        int[] result = new int[n + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[src] = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[] { 0, src });
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int u = current[1];
            int currentDistance = current[0];
            if (currentDistance > result[u]) {
                continue;
            }
            for (int[] neighbour : adj.get(u)) {
                int v = neighbour[0];
                int weight = neighbour[1];
                if (result[v] > (weight + result[u])) {
                    result[v] = weight + result[u];
                    minHeap.offer(new int[] { result[v], v });
                }
            }
        }
        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            maxDistance = Math.max(maxDistance, result[i]);
        }
        return maxDistance == Integer.MAX_VALUE ? -1 : maxDistance;
    }
}