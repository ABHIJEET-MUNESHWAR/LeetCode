class Solution {
    int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 } };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        Queue<int[]> queue = new LinkedList<>();
        int steps = 1;
        queue.add(new int[] { 0, 0 });
        boolean[][] isVisited = new boolean[n][n];
        isVisited[0][0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] current = queue.poll();
                int i = current[0];
                int j = current[1];
                for (int[] direction : directions) {
                    int i_ = i + direction[0];
                    int j_ = j + direction[1];
                    if (i_ == n - 1 && j_ == n - 1) {
                        return steps + 1;
                    }
                    if (i_ >= 0 && j_ >= 0 && i_ < n && j_ < n && grid[i_][j_] != 1 && !isVisited[i_][j_]) {
                        isVisited[i_][j_] = true;
                        queue.add(new int[] { i_, j_ });
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}