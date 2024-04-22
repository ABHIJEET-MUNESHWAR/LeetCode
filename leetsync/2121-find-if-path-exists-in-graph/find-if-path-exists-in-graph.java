class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Create Adjacency List
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        // Fill values
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }
        boolean[] isVisited = new boolean[n];
        return dfs(adjacencyList, source, destination, isVisited);
    }

    private boolean dfs(List<List<Integer>> adjacencyList, int currentNode, int destination,
            boolean[] isVisited) {
        isVisited[currentNode] = true;
        if (currentNode == destination) {
            return true;
        }
        // Visit all neighbours of current node
        for (Integer neighbor : adjacencyList.get(currentNode)) {
            if (!isVisited[neighbor]) {
                isVisited[neighbor] = true;
                boolean isFound = dfs(adjacencyList, neighbor, destination, isVisited);
                if (isFound) {
                    return true;
                }
            }
        }
        return false;
    }
}