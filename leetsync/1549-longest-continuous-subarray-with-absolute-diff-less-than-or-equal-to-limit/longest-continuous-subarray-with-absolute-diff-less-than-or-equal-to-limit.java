class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int maxLength = 0;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int size = nums.length;
        int left = 0, right = 0;

        while (right < size) {

            treeMap.put(nums[right], treeMap.getOrDefault(nums[right], 0) + 1);

            while ((treeMap.lastKey() - treeMap.firstKey()) > limit) {

                treeMap.put(nums[left], treeMap.getOrDefault(nums[left], 0) - 1);
                if (treeMap.get(nums[left]) == 0) {
                    treeMap.remove(nums[left]);
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}