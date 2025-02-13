class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int minOperations = 0;
        for (int num : nums) {
            pq.add((long) num);
        }
        while (!pq.isEmpty() && (pq.size() > 1) && (pq.peek() < k)) {
            long first = pq.poll();
            long second = pq.poll();
            long third = Math.min(first, second) * 2L + Math.max(first, second);
            pq.add(third);
            minOperations++;
        }
        return minOperations;
    }
}