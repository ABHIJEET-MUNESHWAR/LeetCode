class Solution {
    public void isCycleDfs(int numCourses, Map<Integer, List<Integer>> adj, int u, boolean[] isVisited,
            boolean[] inRecursion, Stack<Integer> stack, boolean hasCycle) {
        isVisited[u] = true;
        inRecursion[u] = true;
        for (int v : adj.getOrDefault(u, new ArrayList<>())) {
            if (inRecursion[v]) {
                hasCycle = true;
                return;
            }
            if (!isVisited[v]) {
                isCycleDfs(numCourses, adj, v, isVisited, inRecursion, stack, hasCycle);
            }
        }
        inRecursion[u] = false;
        stack.push(u);
    }

    public int[] findOrder(int numCourses, int[][] edges) {
        Stack<Integer> stack = new Stack<>();
        boolean[] isVisited = new boolean[numCourses];
        boolean[] inRecursion = new boolean[numCourses];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(v, key -> new ArrayList<>()).add(u);
        }
        boolean hasCycle = false;
        for (int i = 0; i < numCourses; i++) {
            if (!isVisited[i]) {
                isCycleDfs(numCourses, adj, i, isVisited, inRecursion, stack, hasCycle);
            }
        }
        if (hasCycle) {
            return new int[] {};
        }
        int[] result = new int[stack.size()];
        int itr = 0;
        while (!stack.isEmpty()) {
            result[itr++] = stack.pop();
        }
        return result;
    }
}