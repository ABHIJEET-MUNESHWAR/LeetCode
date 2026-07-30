class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, key -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, key -> new ArrayList<>()).add(u);
        }
        return dfs(adj, hasApple, 0, -1);
    }

    public int dfs(Map<Integer, List<Integer>> adj, List<Boolean> hasApple, int u, int previousNode) {
        int time = 0;
        for (int v : adj.getOrDefault(u, Collections.emptyList())) {
            if (v == previousNode) {
                continue;
            }
            int timeFromMyChild = dfs(adj, hasApple, v, u);
            if (timeFromMyChild > 0 || hasApple.get(v)) {
                time += timeFromMyChild + 2;
            }
        }
        return time;
    }
}