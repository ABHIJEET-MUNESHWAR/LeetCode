class Solution {
    public int maximumDetonation(int[][] bombs) {
        int size = bombs.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    continue;
                }
                long x1 = bombs[i][0];
                long y1 = bombs[i][1];
                long r1 = bombs[i][2];
                long x2 = bombs[j][0];
                long y2 = bombs[j][1];
                long r2 = bombs[j][2];
                long distance = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
                if ((r1 * r1) >= distance) {
                    graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < size; i++) {
            boolean[] visited = new boolean[size];
            int count = dfs(graph, visited, i);
            result = Math.max(result, count);
        }
        return result;
    }

    private int dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        int count = 1;
        if (!graph.containsKey(node)) {
            return count;
        }
        for (int nextNode : graph.get(node)) {
            if (!visited[nextNode]) {
                count += dfs(graph, visited, nextNode);
            }
        }
        return count;
    }
}