class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {

        int n = nums.length;
        Map<Long, Long> map = new HashMap<>();
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0])); // {freq, ID}
        long[] result = new long[n];
        for (int i = 0; i < n; i++) {
            long id = nums[i];
            long frequency = freq[i];
            map.put(id, map.getOrDefault(id, 0L) + frequency);
            pq.add(new long[] { map.get(id), id });
            while (!pq.isEmpty() && map.get(pq.peek()[1]) != pq.peek()[0]) {
                pq.poll();
            }
            result[i] = pq.peek()[0];
        }
        return result;
    }
}