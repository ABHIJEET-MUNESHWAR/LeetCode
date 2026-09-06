class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int freshOranges = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        if (freshOranges == 0) {
            return 0;
        }
        int minutes = 0;
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        while (!queue.isEmpty()) {
            int N = queue.size();
            while (N-- > 0) {
                int[] currentCell = queue.poll();
                int i = currentCell[0];
                int j = currentCell[1];

                for (int[] dir : directions) {
                    int new_i = i + dir[0];
                    int new_j = j + dir[1];
                    if (new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && grid[new_i][new_j] == 1) {
                        queue.add(new int[] { new_i, new_j });
                        grid[new_i][new_j] = 2;
                        freshOranges--;
                    }
                }
            }
            minutes++;
        }
        return freshOranges == 0 ? minutes - 1 : -1;
    }
}