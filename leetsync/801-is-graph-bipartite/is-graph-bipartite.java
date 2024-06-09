class Solution {

    public boolean isBipartite(int[][] graph) {
        int vertexCount = graph.length;
        int[] colors = new int[vertexCount];
        Arrays.fill(colors, -1); // No nodes coloured at the start
        // Red: 1
        // Green: 0
        for (int i = 0; i < vertexCount; i++) {
            if (colors[i] == -1) {
                if (!checkBipartiteDFS(graph, i, colors, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkBipartiteDFS(int[][] graph, int currentNode, int[] colors, int currentColor) {
        colors[currentNode] = currentColor;
        for (int neighbor : graph[currentNode]) {
            if (colors[neighbor] == colors[currentNode]) {
                return false;
            }
            if (colors[neighbor] == -1) {
                int colourOfNeighbor = 1 - currentColor;
                if (!checkBipartiteDFS(graph, neighbor, colors, colourOfNeighbor)) {
                    return false;
                }
            }
        }
        return true;
    }
}