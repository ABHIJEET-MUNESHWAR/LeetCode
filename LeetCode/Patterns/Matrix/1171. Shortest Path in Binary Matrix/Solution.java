class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (n == 0 || grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        boolean[][] isVisited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 0, 0 });
        int path = 1;
        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            while (queueSize-- > 0) {
                int[] currentPosition = queue.poll();
                int currentX = currentPosition[0];
                int currentY = currentPosition[1];
                if ((currentX == (n - 1)) && (currentY == (n - 1))) {
                    return path;
                }
                for (int[] direction : directions) {
                    int nextX = currentX + direction[0];
                    int nextY = currentY + direction[1];
                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && grid[nextX][nextY] == 0
                            && !isVisited[nextX][nextY]) {
                        isVisited[nextX][nextY] = true;
                        queue.offer(new int[] { nextX, nextY });
                    }
                }
            }
            path++;
        }
        return -1;
    }
}