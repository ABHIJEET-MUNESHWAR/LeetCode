class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> numToIndexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int remaining = target - nums[i];
            if (numToIndexMap.containsKey(remaining)) {
                return new int[] { i, numToIndexMap.get(remaining) };
            }
            numToIndexMap.put(nums[i], i);
        }
        return new int[] {};
    }
}