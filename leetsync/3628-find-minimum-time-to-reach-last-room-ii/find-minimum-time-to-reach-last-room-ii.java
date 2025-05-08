class Solution {
    int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length;
        int n = moveTime[0].length;
        int[][] result = new int[m][n];
        for (int[] row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        result[0][0] = 0;
        pq.offer(new int[] { 0, 0, 0 });
        while (!pq.isEmpty()) {
            int[] currentCell = pq.poll();
            int currentTime = currentCell[0];
            int i = currentCell[1];
            int j = currentCell[2];
            if (i == m - 1 && j == n - 1) {
                return currentTime;
            }
            for (int[] direction : directions) {
                int i_ = i + direction[0];
                int j_ = j + direction[1];
                if (i_ >= 0 && j_ >= 0 && i_ < m && j_ < n) {
                    int wait = Math.max(0, moveTime[i_][j_] - currentTime);
                    int moveCost = (i_ + j_) % 2 == 0 ? 2 : 1;
                    int arriveTime = currentTime + wait + moveCost;
                    if (result[i_][j_] > arriveTime) {
                        result[i_][j_] = arriveTime;
                        pq.offer(new int[] { arriveTime, i_, j_ });
                    }
                }
            }
        }
        return -1;
    }
}