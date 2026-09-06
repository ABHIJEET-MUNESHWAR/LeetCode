class Solution {
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] colors = new int[v];
        Arrays.fill(colors, -1);
        // Red: 1
        // Green: 0
        for (int i = 0; i < v; i++) {
            if (colors[i] == -1) {
                if (!checkBipartiteDFS(graph, colors, i, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkBipartiteDFS(int[][] graph, int[] colors, int currentNode, int currentColor) {
        colors[currentNode] = currentColor;
        for (int v : graph[currentNode]) {
            if (colors[v] == currentColor) {
                return false;
            }
            if (colors[v] == -1) {
                int nextColor = 1 - currentColor;
                colors[v] = nextColor;
                if (!checkBipartiteDFS(graph, colors, v, nextColor)) {
                    return false;
                }
            }
        }
        return true;
    }
}