class Solution {
    public boolean isCycleDfs(Map<Integer, List<Integer>> adj, boolean[] isVisited, boolean[] inRecursion, int u) {
        isVisited[u] = true;
        inRecursion[u] = true;
        for (int v : adj.getOrDefault(u, new ArrayList<>())) {
            if (!isVisited[v] && isCycleDfs(adj, isVisited, inRecursion, v)) {
                return true;
            } else if (inRecursion[v]) {
                return true;
            }
        }
        inRecursion[u] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int u = prerequisite[0];
            int v = prerequisite[1];
            adj.computeIfAbsent(v, key -> new ArrayList<>()).add(u);
        }
        boolean[] isVisited = new boolean[numCourses];
        boolean[] inRecursion = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!isVisited[i] && isCycleDfs(adj, isVisited, inRecursion, i)) {
                return false;
            }
        }
        return true;
    }
}