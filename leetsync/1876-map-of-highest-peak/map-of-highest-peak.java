class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] height = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                    queue.add(new int[] { i, j });
                } else {
                    height[i][j] = -1;
                }
            }
        }
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] current = queue.poll();
                int i = current[0];
                int j = current[1];
                for (int[] dir : directions) {
                    int i_ = i + dir[0];
                    int j_ = j + dir[1];
                    if (i_ >= 0 && j_ >= 0 && i_ < m && j_ < n && height[i_][j_] == -1) {
                        height[i_][j_] = height[i][j] + 1;
                        queue.add(new int[] { i_, j_ });
                    }
                }
            }
        }
        return height;
    }
}