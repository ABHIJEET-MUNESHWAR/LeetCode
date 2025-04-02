class Solution {
    public long maximumTripletValue(int[] nums) {
        long maxI = 0, maxDiff = 0, maxResult = 0;
        for (int num : nums) {
            maxResult = Math.max(maxResult, num * maxDiff);
            maxDiff = Math.max(maxDiff, maxI - num);
            maxI = Math.max(maxI, num);
        }
        return maxResult;
    }
}