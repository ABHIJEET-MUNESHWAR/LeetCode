class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] matrix = new int[k][k];
        List<Integer> topologicalRows = topologicalSortBfs(rowConditions, k);
        List<Integer> topologicalCols = topologicalSortBfs(colConditions, k);
        if (topologicalCols.isEmpty() || topologicalRows.isEmpty()) {
            return new int[][] {}; // Found cycle. Answer is not possible.
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

    private List<Integer> topologicalSortBfs(int[][] edges, int n) {
        // Build adjacency list
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int[] inDegrees = new int[n + 1];
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjacencyList.get(u).add(v);
            inDegrees[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
                count++;
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            order.add(u);
            for (int v : adjacencyList.get(u)) {
                inDegrees[v]--;
                if (inDegrees[v] == 0) {
                    queue.add(v);
                    count++;
                }
            }
        }
        if (count != n) {
            return new ArrayList<>(); // Cycle detected
        }
        return order;
    }
}