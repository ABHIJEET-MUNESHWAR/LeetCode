class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int answer = 0;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) {
            return -1;
        }
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { -1, 1 }, { 1, 1 }, { -1, -1 }, { 1, -1 } };
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0 });
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            answer++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] currentPosition = queue.poll();
                if (currentPosition[0] == row - 1 && currentPosition[1] == col - 1) {
                    return answer;
                }
                for (int[] direction : directions) {
                    int nextX = currentPosition[0] + direction[0];
                    int nextY = currentPosition[1] + direction[1];
                    if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col || visited[nextX][nextY]
                            || grid[nextX][nextY] == 1) {
                        continue;
                    }
                    visited[nextX][nextY] = true;
                    queue.add(new int[] { nextX, nextY });
                }
            }
        }
        return -1;
    }
}