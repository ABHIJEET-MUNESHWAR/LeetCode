class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int mapLength = 0, left = 0, right = 0;
        Map<Integer, Integer> numToFreqMap = new HashMap<>();
        int n = nums.length;
        while (right < n) {
            numToFreqMap.put(nums[right], numToFreqMap.getOrDefault(nums[right], 0) + 1);
            while (numToFreqMap.get(nums[right]) > k) {
                numToFreqMap.put(nums[left], numToFreqMap.getOrDefault(nums[left], 0) - 1);
                left++;
            }
            mapLength = Math.max(mapLength, right - left + 1);
            right++;
        }
        return mapLength;
    }
}