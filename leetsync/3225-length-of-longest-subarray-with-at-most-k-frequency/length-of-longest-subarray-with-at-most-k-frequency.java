class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int maxLength = 0;
        int size = nums.length;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        while (end < size) {
            // expansion
            // Include elements into window
            frequencyMap.put(nums[end], frequencyMap.getOrDefault(nums[end], 0) + 1);

            // shrinking
            // If window is invalid, then shrink it
            while (frequencyMap.get(nums[end]) > k) {
                frequencyMap.put(nums[start], frequencyMap.get(nums[start]) - 1);
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }
        return maxLength;
    }
}