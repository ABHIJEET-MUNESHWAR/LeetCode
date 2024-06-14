class Solution {

    int count = 0;

    class Pair {
        int node;
        int sign;

        public Pair(int node, int sign) {
            this.node = node;
            this.sign = sign;
        }
    }

    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Pair>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] connection : connections) {
            graph.get(connection[0]).add(new Pair(connection[1], 1));
            graph.get(connection[1]).add(new Pair(connection[0], 0));
        }
        dfs(graph, 0, -1);
        return count;
    }

    private void dfs(Map<Integer, List<Pair>> graph, int currentNode, int parent) {
        for (Pair pair : graph.get(currentNode)) {
            if (pair.node != parent) {
                count += pair.sign;
                dfs(graph, pair.node, currentNode);
            }
        }
    }
}