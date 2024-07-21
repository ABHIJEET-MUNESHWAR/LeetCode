class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] matrix = new int[k][k];
        List<Integer> topologicalRows = topologicalSort(rowConditions, k);
        List<Integer> topologicalCols = topologicalSort(colConditions, k);
        if (topologicalCols.isEmpty() || topologicalRows.isEmpty()) {
            return new int[][]{}; // Found cycle. Answer is not possible.
        }
        Map<Integer, Integer> positionMap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            positionMap.put(topologicalCols.get(i), i);
        }
        for (int i = 0; i < k; i++) {
            int element = topologicalRows.get(i);
            if (positionMap.containsKey(element)) {
                matrix[i][positionMap.get(element)] = element;
            }
        }
        return matrix;
    }

    private List<Integer> topologicalSort(int[][] edges, int n) {
        // Build adjacency list
        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        List<Integer> order = new ArrayList<>();
        int[] visited = new int[n + 1]; // 0: not visited, 1: DFS is in progress, 2: visited
        boolean[] hasCycle = { false };
        for (int[] edge : edges) {
            adjacencyMap.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0) {
                dfs(i, adjacencyMap, visited, stack, hasCycle);
                if (hasCycle[0]) {
                    return new ArrayList<>(); // no ordering possible
                }
            }
        }
        while (!stack.isEmpty()) {
            order.add(stack.pop());
        }
        return order;
    }

    private void dfs(int node, Map<Integer, List<Integer>> adjacencyMap, int[] visited, Stack<Integer> stack,
            boolean[] hasCycle) {
        visited[node] = 1; // Mark node as visiting
        for (int neighbour : adjacencyMap.getOrDefault(node, new ArrayList<>())) {
            if (visited[neighbour] == 0) {
                dfs(neighbour, adjacencyMap, visited, stack, hasCycle);
            } else if (visited[neighbour] == 1) {
                hasCycle[0] = true; // Cycle detected
                return;
            }
        }
        visited[node] = 2; // Mark node as visited
        stack.push(node); // Add node to the stack
    }
}