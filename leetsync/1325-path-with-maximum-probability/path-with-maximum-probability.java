class Solution {
    class Edge {
        int node;
        double probability;

        public Edge(int node, double probability) {
            this.node = node;
            this.probability = probability;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            graph[edge[0]].add(new Edge(edge[1], succProb[i]));
            graph[edge[1]].add(new Edge(edge[0], succProb[i]));
        }
        return dijkstra(n, graph, start, end);
    }

    public double dijkstra(int vertices, List<Edge>[] graph, int start, int end) {
        double[] distances = new double[vertices];
        distances[start] = 1;
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Double.compare(b.probability, a.probability));
        pq.add(new Edge(start, 1));
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int node = edge.node;
            double distance = edge.probability;
            for (Edge neighbour : graph[node]) {
                int neighbourNode = neighbour.node;
                double neighbourDistance = neighbour.probability;
                if (distances[neighbourNode] < (neighbourDistance * distance)) {
                    distances[neighbourNode] = (neighbourDistance * distance);
                    pq.add(new Edge(neighbourNode, distances[neighbourNode]));
                }
            }
        }
        return distances[end];
    }
}