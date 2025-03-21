class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        return dfs(adjacencyList, 0, -1, hasApple);
    }

    private int dfs(Map<Integer, List<Integer>> adjacencyList, int current, int parent, List<Boolean> hasApple) {
        int time = 0;
        for (int child : adjacencyList.get(current)) {
            if (child == parent) {
                continue;
            }
            int timeFromChild = dfs(adjacencyList, child, current, hasApple);
            if (timeFromChild > 0 || hasApple.get(child)) {
                time += timeFromChild + 2;
            }
        }
        return time;
    }
}