class Solution {
    private Map<Integer, List<Integer>> adj = new HashMap<>();

    public int bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(0);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int node = queue.poll();
                if (node == n - 1) {
                    return level;// Found the destination node
                }
                for (int neighbour : adj.getOrDefault(node, new ArrayList<>())) {
                    if (!visited[neighbour]) {
                        queue.add(neighbour);
                        visited[neighbour] = true;
                    }
                }
            }
            level++;
        }
        return -1;// If destination node is unreachable
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        adj.clear();
        // Initialize adjacency list with direct edges (i -> i + 1)
        for (int i = 0; i < n; i++) {
            adj.computeIfAbsent(i, k -> new ArrayList<>()).add(i + 1);
        }
        int k = queries.length;
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            adj.computeIfAbsent(u, k1 -> new ArrayList<>()).add(v);
            result[i] = bfs(n);
        }
        return result;
    }
}