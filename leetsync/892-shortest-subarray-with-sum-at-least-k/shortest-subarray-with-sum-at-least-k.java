//Approach (Using sliding window + monotinic deque
//T.C : O(n)
//S.C : O(n)
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int N = nums.length;

        Deque<Integer> deq = new LinkedList<>();
        long[] cumulativeSum = new long[N]; // This stores the cumulative sum

        int result = Integer.MAX_VALUE;
        int j = 0;

        // Compute cumulative sum in the cumulativeSum array using while loop
        while (j < N) {
            if (j == 0)
                cumulativeSum[j] = nums[j];
            else
                cumulativeSum[j] = cumulativeSum[j - 1] + nums[j];

            // If the cumulative sum from the start to j is already >= k, update result
            if (cumulativeSum[j] >= k)
                result = Math.min(result, j + 1);

            // Remove indices from the deque where the subarray sum is >= k
            while (!deq.isEmpty() && cumulativeSum[j] - cumulativeSum[deq.peekFirst()] >= k) {
                result = Math.min(result, j - deq.peekFirst()); // Calculate the length of the subarray
                deq.pollFirst(); // Remove the front index from the deque
            }

            // Maintain the monotonic property of the deque (increasing order of cumulative
            // sums)
            while (!deq.isEmpty() && cumulativeSum[j] <= cumulativeSum[deq.peekLast()]) {
                deq.pollLast(); // Remove indices that won't be useful
            }

            // Add the current index to the deque
            deq.offerLast(j);

            j++; // Increment j to move to the next index
        }

        // Return the result if we found a valid subarray, otherwise return -1
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}