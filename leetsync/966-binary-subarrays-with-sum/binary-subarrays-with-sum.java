class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        int count = 0;
        int size = nums.length;
        Map<Integer, Integer> prefixSumToFrequencyMap = new HashMap<>();
        int prefixSum = 0;
        prefixSumToFrequencyMap.put(0, 1);
        for (int i = 0; i < size; i++) {
            prefixSum += nums[i];
            if (prefixSumToFrequencyMap.containsKey(prefixSum - goal)) {
                count += prefixSumToFrequencyMap.get(prefixSum - goal);
            }
            prefixSumToFrequencyMap.put(
                    prefixSum, prefixSumToFrequencyMap.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}