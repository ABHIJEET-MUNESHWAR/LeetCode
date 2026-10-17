class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                }
            }
        }
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int minTime = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] current = queue.poll();
                for (int[] direction : directions) {
                    int i_ = current[0] + direction[0];
                    int j_ = current[1] + direction[1];
                    if (i_ >= 0 && j_ >= 0 && i_ < m && j_ < n && grid[i_][j_] == 1) {
                        grid[i_][j_] = 2;
                        queue.offer(new int[] { i_, j_ });
                    }
                }
            }
            minTime++;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        if (minTime == 0) {
            return 0;
        }
        minTime--;
        return minTime;
    }
}