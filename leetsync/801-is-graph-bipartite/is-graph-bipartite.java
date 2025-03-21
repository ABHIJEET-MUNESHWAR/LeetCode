class Solution {

    public boolean isBipartite(int[][] graph) {
        int vortexCount = graph.length;
        int[] colors = new int[vortexCount];
        Arrays.fill(colors, -1);
        // Red: 1
        // Green: 0
        for (int i = 0; i < vortexCount; i++) {
            if (colors[i] == -1) {
                if (!checkBipartiteBFS(graph, i, colors, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkBipartiteBFS(int[][] graph, int currentNode, int[] colors, int currentColor) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(currentNode);
        colors[currentNode] = currentColor;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
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