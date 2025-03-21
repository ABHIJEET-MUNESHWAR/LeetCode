class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] colors = new int[n + 1];
        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            colors[i] = -1;
        }
        for (int i = 1; i <= n; i++) {
            adjacencyMap.put(i, new ArrayList<>());
        }
        for (int[] dislike : dislikes) {
            adjacencyMap.get(dislike[0]).add(dislike[1]);
            adjacencyMap.get(dislike[1]).add(dislike[0]);
        }
        for (int i = 1; i <= n; i++) {
            if (colors[i] == -1) {
                if (!isBiPartite(adjacencyMap, i, colors, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBiPartite(Map<Integer, List<Integer>> graph, int currentNode, int[] colors, int color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(currentNode);
        colors[currentNode] = color;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (colors[neighbor] == colors[node]) {
                    return false;
                } else if (colors[neighbor] == -1) {
                    colors[neighbor] = 1 - colors[node];
                    queue.add(neighbor);
                }
            }
        }
        return true;
    }
}