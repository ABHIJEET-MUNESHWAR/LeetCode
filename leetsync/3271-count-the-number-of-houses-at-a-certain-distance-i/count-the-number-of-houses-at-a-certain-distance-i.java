class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int[] result = new int[n];
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }
        for (int i = 1; i <= n; i++) {
            graph[i][i] = 0;
            if (i < n) {
                graph[i][i + 1] = 1;
            }
            if (i > 0) {
                graph[i][i - 1] = 1;
            }
        }
        graph[x][y] = 1;
        graph[y][x] = 1;
        for (int via = 1; via <= n; via++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][via] != Integer.MAX_VALUE && graph[via][j] != Integer.MAX_VALUE) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][via] + graph[via][j]);
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] != Integer.MAX_VALUE && i != j) {
                    result[graph[i][j] - 1]++;
                }
            }
        }
        return result;
    }
}