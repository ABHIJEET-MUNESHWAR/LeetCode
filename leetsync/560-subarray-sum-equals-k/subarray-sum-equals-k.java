class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> diffToFreqMap = new HashMap<>();
        int result = 0;
        diffToFreqMap.put(0, 1);
        int prefixSum = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            int diff = prefixSum - k;
            if (diffToFreqMap.containsKey(diff)) {
                result += diffToFreqMap.get(diff);
            }
            diffToFreqMap.put(prefixSum, diffToFreqMap.getOrDefault(prefixSum, 0) + 1);
        }
        return result;
    }
}