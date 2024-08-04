class Solution {

    int mod = 1000000007;

    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < n; i++) {
            queue.add(new int[] {nums[i], i});
        }
        int result = 0;
        for (int i = 1; i <= right; i++) {
            int[] current = queue.poll();
            // If the current index is within the desired range, add the value to the result
            if (i >= left) {
                result = (result + current[0]) % mod;
            }
            // If index is less than the last index, increment it and add the new subarray sum to the queue
            if (current[1] < n - 1) {
                int nextIndex = current[1] + 1;
                queue.add(new int[] {current[0] + nums[nextIndex], nextIndex});
            }
        }
        return result;
    }
}