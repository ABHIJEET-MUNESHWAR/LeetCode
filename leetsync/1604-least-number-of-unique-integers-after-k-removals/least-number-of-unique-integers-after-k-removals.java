class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> numToFrequencyMap = new HashMap<>();
        for (int num : arr) {
            numToFrequencyMap.put(num, numToFrequencyMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(numToFrequencyMap.values());
        int removedElements = 0;
        while (!minHeap.isEmpty()) {
            removedElements += minHeap.peek();
            if (removedElements > k) {
                return minHeap.size();
            }
            minHeap.poll();
        }
        return 0; // All were removed
    }
}