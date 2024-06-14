class Solution {
    class Pair {
        int node;
        int score;

        public Pair(int node, int score) {
            this.node = node;
            this.score = score;
        }
    }

    int minScore = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {
        Map<Integer, List<Pair>> graph = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            graph.putIfAbsent(i, new ArrayList<>());
        }
        for (int[] road : roads) {
            graph.get(road[0]).add(new Pair(road[1], road[2]));
            graph.get(road[1]).add(new Pair(road[0], road[2]));
        }
        boolean[] visited = new boolean[n + 1];
        dfs(graph, visited, 1);
        return minScore;
    }

    private void dfs(Map<Integer, List<Pair>> graph, boolean[] visited, int currentNode) {
        visited[currentNode] = true;
        for (Pair pair : graph.get(currentNode)) {
            minScore = Math.min(minScore, pair.score);
            if (!visited[pair.node]) {
                dfs(graph, visited, pair.node);
            }
        }
    }
}