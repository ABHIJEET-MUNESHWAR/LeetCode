class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long n = nums.length;
        long result = 0, currentWindowSum = 0;
        HashSet<Integer> set = new HashSet<>();
        int left = 0, right = 0;
        while (right < n) {
            // Adjust the window if nums[j] is already in the set
            while (set.contains(nums[right])) {
                currentWindowSum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
            currentWindowSum += nums[right];
            set.add(nums[right]);
            // Check if window size is equal to k
            if ((right - left + 1) == k) {
                result = Math.max(result, currentWindowSum);
                // Shrink the window from the left
                currentWindowSum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
            right++;
        }
        return result;
    }
}