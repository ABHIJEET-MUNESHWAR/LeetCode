class Solution {
    int[][] direction = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        pq.add(new int[] { 0, 0, 0 });
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentCost = current[0];
            int i = current[1];
            int j = current[2];
            if (dist[i][j] < currentCost) {
                continue;
            }
            for (int dir = 0; dir < 4; dir++) {
                int i_ = i + direction[dir][0];
                int j_ = j + direction[dir][1];
                if (i_ >= 0 && i_ < m && j_ >= 0 && j_ < n) {
                    int gridDir = grid[i][j];
                    int dirCost = ((gridDir - 1 != dir) ? 1 : 0);
                    int newCost = currentCost + dirCost;
                    if (dist[i_][j_] > newCost) {
                        dist[i_][j_] = newCost;
                        pq.add(new int[] { newCost, i_, j_ });
                    }
                }
            }
        }
        return dist[m - 1][n - 1];// min cost to reach (m-1, n-1)
    }
}