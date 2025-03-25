class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int k = 3;
        boolean[] isFlipped = new boolean[n];
        int totalFlips = 0;
        int flipCountFromPastForCurrentI = 0;
        for (int i = 0; i < n; i++) {
            if (i >= k && isFlipped[i - k]) {
                flipCountFromPastForCurrentI--;
            }
            if (flipCountFromPastForCurrentI % 2 == nums[i]) {
                if (i + k > n) {
                    return -1;
                }
                totalFlips++;
                isFlipped[i] = true;
                flipCountFromPastForCurrentI++;
            }
        }
        return totalFlips;
    }
}