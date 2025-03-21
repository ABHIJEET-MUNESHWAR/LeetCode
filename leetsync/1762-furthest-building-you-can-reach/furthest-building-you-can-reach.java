class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n - 1; i++) {
            if (heights[i] >= heights[i + 1]) {
                continue;
            }
            int diff = heights[i + 1] - heights[i];
            pq.add(diff);
            bricks -= diff;
            if (bricks < 0) {
                bricks += pq.poll();
                if (ladders > 0) {
                    ladders--;
                } else {
                    return i;
                }
            }
        }
        return n - 1;
    }
}