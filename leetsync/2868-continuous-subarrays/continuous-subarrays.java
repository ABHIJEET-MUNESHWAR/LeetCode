class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        // Min-heap for smallest elements
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        // Max-heap for largest elements
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        int i = 0, j = 0;
        long count = 0;
        while (j < n) {
            // Add the current element to both heaps
            minHeap.offer(new int[] { nums[j], j });
            maxHeap.offer(new int[] { nums[j], j });
            // Maintain the condition that the difference between max and min <= 2
            while (Math.abs(maxHeap.peek()[0] - minHeap.peek()[0]) > 2) {
                i++;
                // Remove elements outside the current window from the maxHeap
                while (!maxHeap.isEmpty() && maxHeap.peek()[1] < i) {
                    maxHeap.poll();
                }
                // Remove elements outside the current window from the min
                while (!minHeap.isEmpty() && minHeap.peek()[1] < i) {
                    minHeap.poll();
                }
            }
            // Add the number of valid subarrays ending at index j
            count += j - i + 1;
            j++;
        }
        return count;
    }
}