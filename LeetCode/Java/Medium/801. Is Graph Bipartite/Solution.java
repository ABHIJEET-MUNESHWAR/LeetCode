class Solution {
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] colors = new int[v];
        for (int i = 0; i < v; i++) {
            colors[i] = -1;
        }
        for (int i = 0; i < v; i++) {
            if (colors[i] == -1) {
                if (!checkBipartiteBFS(graph, colors, i, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkBipartiteBFS(int[][] graph, int[] colors, int currentNode, int currentColor) {
        colors[currentNode] = currentColor;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(currentNode);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int v : graph[node]) {
                int nextColor = 1 - colors[node];
                if (colors[v] == colors[node]) {
                    return false;
                }
                if (colors[v] == -1) {
                    colors[v]=nextColor;
                    queue.add(v);
                }
            }
        }
        return true;
    }

}