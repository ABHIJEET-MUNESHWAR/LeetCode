/*
j - i       != nums[j] - nums[i]
nums[i] - i != nums[j] - j;
*/
class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] - i;
        }
        Map<Integer, Integer> numToFreq = new HashMap<>();
        numToFreq.put(nums[0], 1);
        long sum = 0;
        for (int j = 1; j < n; j++) {
            int countOfNumsJ = numToFreq.getOrDefault(nums[j], 0);
            int totalNumsBeforej  = j;
            int badPairs = totalNumsBeforej-countOfNumsJ;
            sum += badPairs;
            numToFreq.put(nums[j], countOfNumsJ + 1);
        }
        return sum;
    }
}