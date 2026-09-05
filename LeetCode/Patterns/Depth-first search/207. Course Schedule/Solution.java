class Solution {
    public boolean isCycleDFS(Map<Integer, List<Integer>> adj, int numCourses, boolean[] isVisited,
            boolean[] inRecursion, int u) {
        isVisited[u] = true;
        inRecursion[u] = true;
        for (int v : adj.getOrDefault(u, new ArrayList<>())) {
            if (!isVisited[v] && isCycleDFS(adj, numCourses, isVisited, inRecursion, v)) {
                return true;
            } else if (inRecursion[v]) {
                return true;
            }
        }
        inRecursion[u] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] isVisited = new boolean[numCourses];
        boolean[] inRecursion = new boolean[numCourses];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(v, key -> new ArrayList<>()).add(u);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!isVisited[i] && isCycleDFS(adj, numCourses, isVisited, inRecursion, i)) {
                return false;
            }
        }
        return true;
    }
}