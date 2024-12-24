public class Solution {

    // Function to build the adjacency list for a tree
    public Map<Integer, List<Integer>> buildAdjList(int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        return adjList;
    }

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        // Build adjacency lists for both trees
        Map<Integer, List<Integer>> adj1 = buildAdjList(edges1);
        Map<Integer, List<Integer>> adj2 = buildAdjList(edges2);

        // Calculate the diameters of both trees
        int d1 = findDiameter(adj1);
        int d2 = findDiameter(adj2);

        // Calculate the longest path that spans across both trees
        int combined = (d1 + 1) / 2 + (d2 + 1) / 2 + 1;

        // Return the maximum of the three possibilities
        return Math.max(Math.max(d1, d2), combined);
    }

    // Function to find the diameter of a tree using two BFS calls
    public int findDiameter(Map<Integer, List<Integer>> adjList) {
        // First BFS to find the farthest node from any arbitrary node (e.g., 0)
        List<Integer> farthestNode = BFS(adjList, 0);

        // Second BFS from the farthest node to determine the diameter
        farthestNode = BFS(adjList, farthestNode.get(0));
        return farthestNode.get(1);
    }

    // BFS helper function to find the farthest node and its distance from the
    // source
    public List<Integer> BFS(Map<Integer, List<Integer>> adjList, int sourceNode) {
        Queue<Integer> que = new LinkedList<>();
        Map<Integer, Boolean> visited = new HashMap<>();

        // Push source node into the queue
        que.add(sourceNode);
        visited.put(sourceNode, true);

        int maxDistance = 0, farthestNode = sourceNode;

        // Explore neighbors
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int currentNode = que.poll();
                // Update farthest node
                farthestNode = currentNode;

                for (int neighbor : adjList.getOrDefault(currentNode, new ArrayList<>())) {
                    // Explore neighbors
                    if (!visited.getOrDefault(neighbor, false)) {
                        visited.put(neighbor, true);
                        que.add(neighbor);
                    }
                }
            }
            if (!que.isEmpty()) {
                maxDistance++;
            }
        }
        return Arrays.asList(farthestNode, maxDistance);
    }
}