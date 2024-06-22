class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        int n = nums.length;
        int count = 0;
        int oddsCount = 0;
        Map<Integer, Integer> oddsFrequencyMap = new HashMap<>();
        oddsFrequencyMap.put(0, 1);
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) {
                oddsCount++;
            }
            int key = oddsCount - k;
            if (oddsFrequencyMap.containsKey(key)) {
                count += oddsFrequencyMap.get(key);
            }
            oddsFrequencyMap.put(oddsCount, oddsFrequencyMap.getOrDefault(oddsCount, 0) + 1);
        }
        return count;
    }
}