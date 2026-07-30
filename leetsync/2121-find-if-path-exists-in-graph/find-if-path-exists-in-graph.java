class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, key -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, key -> new ArrayList<>()).add(u);
        }
        return bfs(n, adj, source, destination);
    }

    public boolean bfs(int n, Map<Integer, List<Integer>> adj, int source, int destination) {
        boolean[] isVisited = new boolean[n];
        isVisited[source] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (u == destination) {
                return true;
            }
            for (int v : adj.getOrDefault(u, new ArrayList<>())) {
                if (!isVisited[v]) {
                    isVisited[v] = true;
                    queue.offer(v);
                }
            }
        }
        return false;
    }
}