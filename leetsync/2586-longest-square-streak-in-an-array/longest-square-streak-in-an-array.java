class Solution {
    public int longestSquareStreak(int[] nums) {
        int n = nums.length;
        int longestStreak = 0;
        Arrays.sort(nums);
        Map<Integer, Integer> numToFreqMap = new HashMap<>();
        for (int num : nums) {
            int root = (int) Math.sqrt(num);
            if (((root * root) == num) && (numToFreqMap.containsKey(root))) {
                numToFreqMap.put(num, numToFreqMap.get(root) + 1);
            } else {
                numToFreqMap.put(num, 1);
            }
            longestStreak = Math.max(longestStreak, numToFreqMap.get(num));
        }
        return longestStreak >= 2 ? longestStreak : -1;
    }
}