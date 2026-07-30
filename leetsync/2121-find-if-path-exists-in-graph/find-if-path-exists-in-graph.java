class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, key -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, key -> new ArrayList<>()).add(u);
        }
        boolean[] isVisited = new boolean[n];
        if (dfs(adj, source, destination, isVisited)) {
            return true;
        }
        return false;
    }

    public boolean dfs(Map<Integer, List<Integer>> adj, int u, int destination, boolean[] isVisited) {
        if (u == destination) {
            return true;
        }
        if (!isVisited[u]) {
            isVisited[u] = true;
        }
        for (Integer v : adj.getOrDefault(u, new ArrayList<>())) {
            if (!isVisited[v] && dfs(adj, v, destination, isVisited)) {
                return true;
            }
        }
        return false;
    }
}