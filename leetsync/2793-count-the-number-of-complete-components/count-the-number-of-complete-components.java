class Solution {
    public void dfs(int i, Map<Integer, List<Integer>> adj, boolean[] visited, int[] info) {
        visited[i] = true;
        info[0]++;
        info[1] += adj.getOrDefault(i, new ArrayList<>()).size();
        for (int ngbr : adj.getOrDefault(i, new ArrayList<>())) {
            if (!visited[ngbr]) {
                dfs(ngbr, adj, visited, info);
            }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int result = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            int[] info = new int[2];
            dfs(i, adj, visited, info);
            if (info[0] * (info[0] - 1) == info[1]) {
                result++;
            }
        }
        return result;
    }
}