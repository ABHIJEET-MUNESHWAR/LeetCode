class Solution {
    boolean hasCycle = false;

    public void hasCycleDFS(Map<Integer, List<Integer>> adj, int numCourses, boolean[] isVisited, boolean[] inRecursion,
            int u,
            Stack<Integer> stack) {
        isVisited[u] = true;
        inRecursion[u] = true;
        for (int v : adj.getOrDefault(u, new ArrayList<>())) {
            if (inRecursion[v]) {
                hasCycle = true;
                return;
            }
            if (!isVisited[v]) {
                hasCycleDFS(adj, numCourses, isVisited, inRecursion, v, stack);
            }
        }
        stack.add(u);
        inRecursion[u] = false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] isVisited = new boolean[numCourses];
        boolean[] inRecursion = new boolean[numCourses];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(v, key -> new ArrayList<>()).add(u);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!isVisited[i]) {
                hasCycleDFS(adj, numCourses, isVisited, inRecursion, i, stack);
            }
        }
        if (hasCycle) {
            return new int[] {};
        }
        int[] result = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;
    }
}