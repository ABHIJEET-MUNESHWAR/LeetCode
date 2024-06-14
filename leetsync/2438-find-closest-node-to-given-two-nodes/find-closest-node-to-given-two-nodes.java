class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        List<Integer> adjacencyList = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            adjacencyList.add(edges[i]);
        }
        int[] distance1 = new int[n];
        Arrays.fill(distance1, Integer.MAX_VALUE);
        int[] distance2 = new int[n];
        Arrays.fill(distance2, Integer.MAX_VALUE);
        boolean[] visited1 = new boolean[n];
        boolean[] visited2 = new boolean[n];
        distance1[node1] = 0;
        distance2[node2] = 0;
        dfs(edges, distance1, visited1, node1);
        dfs(edges, distance2, visited2, node2);

        int minDistanceNode = -1;
        int minDistanceTillNow = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int maxDistance = Math.max(distance1[i], distance2[i]);
            if (minDistanceTillNow > maxDistance) {
                minDistanceTillNow = maxDistance;
                minDistanceNode = i;
            }
        }
        return minDistanceNode;
    }

    private void dfs(int[] edges, int[] distance, boolean[] visited, int node) {
        visited[node] = true;
        int next = edges[node];
        if (next != -1 && !visited[next]) {
            visited[next] = true;
            distance[next] = distance[node] + 1;
            dfs(edges, distance, visited, next);
        }
    }
}