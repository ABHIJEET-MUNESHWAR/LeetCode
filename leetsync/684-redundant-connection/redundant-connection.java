class Solution {
    public boolean dfs(Map<Integer, List<Integer>> adj, int u, int v, boolean[] visited) {
        visited[u] = true;
        if (u == v) {
            return true;
        }
        for (int neighbour : adj.get(u)) {
            if (visited[neighbour]) {
                continue;
            }
            if (dfs(adj, neighbour, v, visited)) {
                return true;
            }
        }
        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (adj.containsKey(u) && adj.containsKey(v)) {
                boolean[] visited = new boolean[n + 1];
                if (dfs(adj, u, v, visited)) {
                    return edge;
                }
            }
            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return new int[0];
    }
}