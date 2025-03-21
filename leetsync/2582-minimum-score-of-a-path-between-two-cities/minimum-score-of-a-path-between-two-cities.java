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
        bfs(graph, 1);
        return minScore;
    }

    private void bfs(Map<Integer, List<Pair>> graph, int currentNode) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(currentNode);
        visited[currentNode] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Pair pair : graph.get(node)) {
                minScore = Math.min(minScore, pair.score);
                if (!visited[pair.node]) {
                    visited[pair.node] = true;
                    queue.add(pair.node);
                }
            }
        }
    }
}