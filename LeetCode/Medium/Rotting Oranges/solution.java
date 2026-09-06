class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                }
            }
        }
        int minutes = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            while (queueSize-- > 0) {
                int[] orangeLocation = queue.poll();
                int i = orangeLocation[0];
                int j = orangeLocation[1];
                for (int[] direction : directions) {
                    int i_ = i + direction[0];
                    int j_ = j + direction[1];
                    if (i_ >= 0 && j_ >= 0 && i_ < m && j_ < n && grid[i_][j_] == 1) {
                        grid[i_][j_] = 2;
                        queue.add(new int[] { i_, j_ });
                    }
                }
            }
            minutes++;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        if (minutes == 0) {
            return 0;
        }
        return minutes - 1;
    }
}