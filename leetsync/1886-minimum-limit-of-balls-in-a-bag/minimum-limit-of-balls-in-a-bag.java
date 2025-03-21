class Solution {
    public boolean isPossible(int[] nums, int maxOperations, int mid) {
        int totalOps = 0;// To bring each number <= mid
        for (int num : nums) {
            int ops = num / mid;
            if (num % mid == 0) {
                ops -= 1;
            }
            totalOps+=ops;
        }
        return totalOps <= maxOperations;
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1;
        int r = Arrays.stream(nums).max().getAsInt();// Find max in nums
        int result = r;// We have to minimize this
        // Binary search: O(n * log(MAX))
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (isPossible(nums, maxOperations, mid)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }
}