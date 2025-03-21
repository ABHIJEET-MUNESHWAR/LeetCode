class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });
        for (int i = 0; i < n; i++) {
            pq.add(new int[] { nums[i], i });
        }

        long score = 0;
        while (!pq.isEmpty()) {
            int[] element = pq.poll();
            int value = element[0];
            int index = element[1];

            if (!visited[index]) {
                visited[index] = true;
                score += value;
                // Mark adjacent indices as visited
                if (index - 1 >= 0) {
                    visited[index - 1] = true;
                }
                if (index + 1 < n) {
                    visited[index + 1] = true;
                }
            }
        }
        return score;
    }
}