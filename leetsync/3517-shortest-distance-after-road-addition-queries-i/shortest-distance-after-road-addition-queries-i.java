class Solution {
    private Map<Integer, List<int[]>> adj = new HashMap<>();

    public int dijkstra(int n) {
        int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] { 0, 0 }); // distance, node
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int d = top[0];
            int node = top[1];
            if (node == n - 1) {
                return result[n - 1];
            }
            if (d > result[node]) {
                continue;
            }
            if (!adj.containsKey(node)) {
                continue;
            }
            for (int[] edge : adj.get(node)) {
                int adjNode = edge[0];
                int dist = edge[1];
                if ((dist + d) < result[adjNode]) {
                    result[adjNode] = dist + d;
                    pq.add(new int[] { d + dist, adjNode });
                }
            }
        }
        return result[n - 1];
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        adj.clear();
        // Initialize adjacency list with direct edges (i -> i + 1)
        for (int i = 0; i < n - 1; i++) {
            adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[] { i + 1, 1 });
        }
        int k = queries.length;
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            adj.computeIfAbsent(u, k1 -> new ArrayList<>()).add(new int[] { v, 1 });
            result[i] = dijkstra(n);
        }
        return result;
    }
}