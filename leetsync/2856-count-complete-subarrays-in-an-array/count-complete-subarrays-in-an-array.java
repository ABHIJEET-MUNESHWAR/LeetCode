class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int num : nums) {
            set.add(num);
        }
        int totalUniqueElements = set.size();
        Map<Integer, Integer> numToFreqMap = new HashMap<>();
        int result = 0;
        int left = 0, right = 0;
        while (right < n) {
            numToFreqMap.put(nums[right], numToFreqMap.getOrDefault(nums[right], 0) + 1);
            while (numToFreqMap.size() == totalUniqueElements) {
                result += n - right;
                numToFreqMap.put(nums[left], numToFreqMap.get(nums[left]) - 1);
                if (numToFreqMap.get(nums[left]) == 0) {
                    numToFreqMap.remove(nums[left]);
                }
                left++;
            }
            right++;
        }
        return result;
    }
}