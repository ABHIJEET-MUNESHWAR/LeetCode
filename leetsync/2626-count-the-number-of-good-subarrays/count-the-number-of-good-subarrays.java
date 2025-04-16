class Solution {
    public long countGood(int[] nums, int k) {
        long pairs = 0;
        long result = 0;
        int n = nums.length;
        int left = 0, right = 0;
        Map<Integer, Integer> numToFreqMap = new HashMap<>();
        while (right < n) {
            pairs += numToFreqMap.getOrDefault(nums[right], 0);
            numToFreqMap.put(nums[right], numToFreqMap.getOrDefault(nums[right], 0) + 1);
            while (pairs >= k) {
                result += (n - right);
                numToFreqMap.put(nums[left], numToFreqMap.get(nums[left]) - 1);
                pairs -= numToFreqMap.get(nums[left]);
                left++;
            }
            right++;
        }
        return result;
    }
}