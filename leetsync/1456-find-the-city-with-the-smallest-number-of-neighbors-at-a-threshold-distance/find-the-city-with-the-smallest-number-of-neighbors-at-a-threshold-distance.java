class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] shortestPathMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(shortestPathMatrix[i], (int) 1e9 + 7);
            shortestPathMatrix[i][i] = 0;
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            shortestPathMatrix[u][v] = weight;
            shortestPathMatrix[v][u] = weight;
        }
        floydWarshall(n, shortestPathMatrix);
        return getCityWithFewestReachable(n, shortestPathMatrix, distanceThreshold);
    }

    public void floydWarshall(int n, int[][] shortestPathMatrix) {
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    shortestPathMatrix[i][j] = Math.min(shortestPathMatrix[i][j],
                            shortestPathMatrix[i][via] + shortestPathMatrix[via][j]);
                }
            }
        }
    }

    private int getCityWithFewestReachable(int n, int[][] shortestPathMatrix, int distanceThreshold) {
        int cityWithFewestReachable = -1;
        int fewestReachableCount = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int reachableCount = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && shortestPathMatrix[i][j] <= distanceThreshold) {
                    reachableCount++;
                }
            }
            if (fewestReachableCount >= reachableCount) {
                fewestReachableCount = reachableCount;
                cityWithFewestReachable = i;
            }
        }
        return cityWithFewestReachable;
    }
}