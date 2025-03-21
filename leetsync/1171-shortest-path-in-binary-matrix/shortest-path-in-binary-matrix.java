class Solution {
    class Pair {
        int x;
        int y;
        int distance;

        public Pair(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        Pair pair = new Pair(0, 0, 1);
        visited[0][0] = true;
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair p1, Pair p2) -> p1.distance - p2.distance);
        pq.add(pair);
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { -1, 1 }, { 1, 1 }, { -1, -1 }, { 1, -1 } };
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int x = p.x;
            int y = p.y;
            int distance = p.distance;
            if (x == n - 1 && y == n - 1) {
                return distance;
            }
            for (int[] direction : directions) {
                int nextX = x + direction[0];
                int nextY = y + direction[1];
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || visited[nextX][nextY]
                        || grid[nextX][nextY] == 1) {
                    continue;
                }
                visited[nextX][nextY] = true;
                Pair nextPair = new Pair(nextX, nextY, distance + 1);
                pq.add(nextPair);
            }
        }
        return -1;
    }
}