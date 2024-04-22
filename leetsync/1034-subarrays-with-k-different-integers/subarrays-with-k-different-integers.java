class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countOfSubarraysWithAtMostK(nums, k) - countOfSubarraysWithAtMostK(nums, k - 1);
    }

    private int countOfSubarraysWithAtMostK(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int start = 0;
        int end = 0;
        int count = 0;
        int size = nums.length;
        while (end < size) {
            // Expansion
            frequencyMap.put(nums[end], frequencyMap.getOrDefault(nums[end], 0) + 1);
            // Shrinking (At most K elements are supported)
            while (frequencyMap.size() > k) {
                frequencyMap.put(nums[start], frequencyMap.getOrDefault(nums[start], 0) - 1);
                if (frequencyMap.get(nums[start]) == 0) {
                    frequencyMap.remove(nums[start]);
                }
                start++;
            }
            count += (end - start + 1);
            end++;
        }
        return count;
    }
}