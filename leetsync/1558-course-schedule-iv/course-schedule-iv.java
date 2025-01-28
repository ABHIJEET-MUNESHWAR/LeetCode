class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] preq : prerequisites) {
            int u = preq[0];
            int v = preq[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        }
        int q = queries.length;
        ArrayList<Boolean> result = new ArrayList<>(q);

        // Process each query
        for (int[] query : queries) {
            int u = query[0];
            int v = query[1];
            boolean[] visited = new boolean[numCourses];
            result.add(dfs(adj, u, v, visited));
        }
        return result;
    }

    public boolean dfs(Map<Integer, List<Integer>> adj, int src, int dest, boolean[] isVisited) {
        isVisited[src] = true;
        if (src == dest) {
            return true; // Yes, we can reach the destination
        }
        boolean isReachable = false;
        for (int adjNode : adj.getOrDefault(src, new ArrayList<>())) {
            if (!isVisited[adjNode]) {
                isReachable = isReachable || dfs(adj, adjNode, dest, isVisited);
            }
        }
        return isReachable;
    }
}