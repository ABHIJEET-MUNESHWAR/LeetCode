class Solution {

    class Edge implements Comparable<Edge> {
        int node;
        int distance;

        public Edge(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge that) {
            return this.distance - that.distance;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        List<List<Edge>> graph = new ArrayList<>();
        int totalVertices = points.length;
        for (int i = 0; i < totalVertices; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < totalVertices; i++) {
            for (int j = i + 1; j < totalVertices; j++) {
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                graph.get(i).add(new Edge(j, distance));
                graph.get(j).add(new Edge(i, distance));
            }
        }
        return prims(totalVertices, graph);
    }

    private int prims(int totalVertices, List<List<Edge>> graph) {
        int totalSum = 0;
        boolean[] visited = new boolean[totalVertices];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0));
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (visited[edge.node]) {
                continue;
            }
            visited[edge.node] = true;
            totalSum += edge.distance;
            for (Edge neighbor : graph.get(edge.node)) {
                if (!visited[neighbor.node]) {
                    pq.add(neighbor);
                }
            }
        }
        return totalSum;
    }
}