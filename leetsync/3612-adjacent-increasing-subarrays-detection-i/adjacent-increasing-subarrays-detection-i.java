class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int currRun = 1;
        int prevRun = 0;
        for (int i = 1; i < n; i++) {
            if (nums.get(i - 1) < nums.get(i)) {
                currRun++;
            } else {
                prevRun = currRun;
                currRun = 1;
            }
            if (currRun >= 2 * k) {
                return true;
            }
            if (Math.min(currRun, prevRun) >= k) {
                return true;
            }
        }
        return false;
    }
}